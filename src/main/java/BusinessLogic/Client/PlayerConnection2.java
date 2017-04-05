package BusinessLogic.Client;

import BusinessLogic.TheGame.CirclePiece;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 26 February 2017.
 */
public class PlayerConnection2 {

    private Socket socket;
    private final int port = 4444;


    public PlayerConnection2()  {
        try {
            socket = new Socket("localhost",port);
        } catch (IOException e) {
            System.out.println("Could not connect");
        }


    }

    public void sendPiece(CirclePiece c) throws IOException {

        ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream());

        ois.writeObject(c);

    }
    public static void main(String[] args) throws IOException {

        PlayerConnection2 p = new PlayerConnection2();

        CirclePiece c = new CirclePiece(new Color(1,1,1,1),2,2);

        p.sendPiece(c);


    }
}

package BusinessLogic.Client;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

/**
 * Created by David Stovlbaek
 * 26 February 2017.
 */
public class PlayerConnection {

    private Socket socket;
    private final int port = 4444;


    PlayerConnection()  {
        try {
            socket = new Socket("localhost",port);
        } catch (IOException e) {
            System.out.println("Could not connect");
        }
    }

    void sendObject(Object object) {
        try {
            ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream());
            ois.writeObject(object);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        PlayerConnection p = new PlayerConnection();

        //CirclePiece c = new CirclePiece(new Color(1,1,1,1),2,2);
        p.sendObject("CONNECTION: " + LocalDateTime.now());


    }
}

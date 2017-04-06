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


    public PlayerConnection(String ip, int port) throws IOException {
        socket = new Socket("localhost",Integer.parseInt(ip));
    }

    public void sendObject(Object object) {
        try {
            ObjectOutputStream ois = new ObjectOutputStream(socket.getOutputStream());
            ois.writeObject(object);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}

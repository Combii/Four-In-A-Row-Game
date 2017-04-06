package BusinessLogic.Client;

import aPresentation.LoginController;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 26 February 2017.
 */
public class PlayerConnection {

    private Socket socket;


    public PlayerConnection() throws IOException {
        socket = new Socket(LoginController.ip, LoginController.port);
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

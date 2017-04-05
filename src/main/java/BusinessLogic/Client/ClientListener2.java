package BusinessLogic.Client;


import BusinessLogic.CirclePiece;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener2 implements Runnable {

    ServerSocket socket = new ServerSocket(4444);



    public ClientListener2() throws IOException {
    }

    @Override
    public void run() {

        Socket client = null;
        try {
            while (true) {
                client = socket.accept();
                System.out.println("Connection");
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                System.out.println((CirclePiece) ois.readObject());

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new ClientListener2().run();
    }



}

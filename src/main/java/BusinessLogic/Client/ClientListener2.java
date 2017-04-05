package BusinessLogic.Client;

import BusinessLogic.TheGame.CirclePiece;

<<<<<<< HEAD
=======

>>>>>>> origin/WIP---Connection
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener2 implements Runnable{

    ServerSocket socket = new ServerSocket(4444);



    public ClientListener2() throws IOException {
    }

    @Override
    public void run() {

        Socket client;
        
        try {
            while (true) {
                client = socket.accept();
                System.out.println("Connection established..");
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

                System.out.println(ois.readObject());


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new ClientListener2().run();
    }



}

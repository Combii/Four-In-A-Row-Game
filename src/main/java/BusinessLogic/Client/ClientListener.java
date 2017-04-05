package BusinessLogic.Client;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener implements Runnable{

    ServerSocket socket = new ServerSocket(4444);



    public ClientListener() throws IOException {
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

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void checkProtocols(String message){




    }

    public static void main(String[] args) throws IOException {
        new ClientListener().run();
    }



}

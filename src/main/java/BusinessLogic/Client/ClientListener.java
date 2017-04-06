package BusinessLogic.Client;


import aPresentation.LoginController;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener implements Runnable{

    ServerSocket socket;

    private Color colorChosen = Color.BLUE;

    private final int port;

    public ClientListener(int port) {
        this.port = port;
        try {
            socket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket client;

        try {
            while (true) {

                client = socket.accept();
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

                checkProtocols(ois.readObject().toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void checkProtocols(String message) throws IOException {
        String protocol = message.substring(0, message.indexOf(':'));
        System.out.println(message);

        if(protocol.equals("CONNECTION")){
            System.out.println("Connection established...");
            String time = message.substring(message.indexOf(':')+1).trim();

            if(LoginController.startedProgramTime < Long.parseLong(time)){
               colorChosen = Color.RED;
                System.out.println("COLOR IS NOW RED");
            }
        }

    }



}

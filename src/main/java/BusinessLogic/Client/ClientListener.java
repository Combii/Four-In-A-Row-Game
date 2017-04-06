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

    private boolean colorPickCheck = true;
    private Color colorChosen = Color.BLUE;

    private final int port;
    private final String ip;

    public ClientListener(String ip, int port) {
        this.port = port;
        this.ip = ip;
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

            if(LoginController.startedProgramTime > Long.parseLong(time)){
                new PlayerConnection(ip, port).sendObject("COLORPICK: RED");
            }
        }
        else if(protocol.equals("COLORPICK")){
                if(message.substring(message.indexOf(':')+1).trim().equals("RED"))
                colorChosen = Color.RED;
                System.out.println("COLOR IS NOW RED");
        }

    }



}

package BusinessLogic.Client;


import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener implements Runnable{

    ServerSocket socket = new ServerSocket(4444);

    private boolean colorPickCheck = true;
    private Color colorChosen = Color.BLUE;

    public ClientListener() throws IOException {
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

    private void checkProtocols(String message){
        String protocol = message.substring(0, message.indexOf(':'));
        //System.out.println(message);

        if(protocol.equals("CONNECTION")){
            System.out.println("Connection established...");
            String time = message.substring(message.indexOf(':')+1).trim();
            //System.out.println(time);

            if(colorPickCheck) {
                new PlayerConnection().sendObject("COLORPICK: RED");
                colorPickCheck = false;
            }
        }
        else if(protocol.equals("COLORPICK")){
            if(colorPickCheck){
                if(message.substring(message.indexOf(':')+1).trim().equals("RED"))
                colorChosen = Color.RED;
                System.out.println("COLOR IS NOW RED");
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new ClientListener().run();
    }



}

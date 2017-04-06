package BusinessLogic.Client;


import aPresentation.FourInARowGameController;
import aPresentation.LoginController;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

/**
 * Created by David Stovlbaek
 * 21 February 2017.
 */
public class ClientListener implements Runnable{

    ServerSocket socket;

    public static Color colorChosen = Color.RED;

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

        if(protocol.equals("CONNECTION")){
            System.out.println("Connection established...");
            String time = message.substring(message.indexOf(':')+1).trim();

            if(LoginController.startedProgramTime > Long.parseLong(time)){
               colorChosen = Color.RED;
                System.out.println("COLOR IS NOW RED");
            }
            else{
                colorChosen = Color.BLUE;
            }
        } else if(protocol.equals("CIRCLESELECTED")) {
            String column = message.substring(message.indexOf(':')+1).trim();

            boolean winCheck = false;

            if(colorChosen.equals(Color.RED))
                winCheck = FourInARowGameController.fourInARowList.setBrick(Integer.parseInt(column), Color.BLUE);
            else
                winCheck = FourInARowGameController.fourInARowList.setBrick(Integer.parseInt(column), Color.RED);

            if(winCheck)
                LoginController.getController().stopGame("You Lost. Game Over");
            else
            FourInARowGameController.waitForTurn = false;

            Platform.runLater(() -> LoginController.getController().setGridPane(FourInARowGameController.fourInARowList));
        }



    }



}

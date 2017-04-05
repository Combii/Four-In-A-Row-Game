package aPresentation;

import BusinessLogic.Client.ClientListener;
import BusinessLogic.Client.PlayerConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class LoginController {

    @FXML
    public Text waitingForConnectionText;

    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    @FXML
    void startGameClicked(ActionEvent event) {
        Thread waitForConnectionNotification = new Thread(() -> {
            try {
                while (true) {
                    waitingForConnectionText.setText("Waiting for Connection");
                    Thread.sleep(500);
                    waitingForConnectionText.setText("Waiting for Connection.");
                    Thread.sleep(500);
                    waitingForConnectionText.setText("Waiting for Connection..");
                    Thread.sleep(500);
                    waitingForConnectionText.setText("Waiting for Connection...");
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException ignored) {
            }
        });
        waitForConnectionNotification.start();

        Thread setupConnection = new Thread(() -> {
        String ip = ipTextField.getText();
        String port = portTextField.getText();

        Thread clientListenerThread = new Thread(new ClientListener(Integer.parseInt(port)));
        clientListenerThread.start();

        PlayerConnection playerConnection = null;

        while(true) {
            try {
                playerConnection = new PlayerConnection(Integer.parseInt(ip));
            } catch (IOException ignored) {
            }

            if(playerConnection != null)
            break;

            //Wait for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //waitNotification.interrupt();

        playerConnection.sendObject("CONNECTION: ");
        clientListenerThread.interrupt();
        waitForConnectionNotification.interrupt();
        });
        setupConnection.start();

    }

}

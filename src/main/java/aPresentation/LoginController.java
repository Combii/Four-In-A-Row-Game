package aPresentation;

import BusinessLogic.Client.ClientListener;
import BusinessLogic.Client.PlayerConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    //Needed for ClientListener
    public static Long startedProgramTime = System.currentTimeMillis();

    public static String ip;
    public static int port;

    private static FXMLLoader loader;


    @FXML
    public Text waitingForConnectionText;

    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    @FXML
    void startGameClicked(ActionEvent event) throws InterruptedException {

        ip = ipTextField.getText();
        port = Integer.parseInt(portTextField.getText());

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

        Thread waitForConnection = new Thread(() -> {
        Thread clientListenerThread = new Thread(new ClientListener(port));
        clientListenerThread.start();

        PlayerConnection playerConnection = null;

        while(true) {
            try {
                playerConnection = new PlayerConnection();
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

        playerConnection.sendObject("CONNECTION: " + startedProgramTime);
        clientListenerThread.interrupt();
        waitForConnectionNotification.interrupt();

        Platform.runLater(this::changeStage);
        });
        waitForConnection.start();
    }

    private void changeStage(){
        try {
            Stage stage = (Stage) waitingForConnectionText.getScene().getWindow();
            //load up OTHER FXML document
            loader = new FXMLLoader(getClass().getResource("/FourInARowGame.fxml"));
            Parent root = loader.load();
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FourInARowGameController getController(){
        return loader.getController();
    }

}

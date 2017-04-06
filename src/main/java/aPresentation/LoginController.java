package aPresentation;

import BusinessLogic.Client.ClientListener;
import BusinessLogic.Client.PlayerConnection;
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
    public static Long startedProgramTime = System.currentTimeMillis();;

    @FXML
    public Text waitingForConnectionText;

    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    @FXML
    void startGameClicked(ActionEvent event) {



        waitingForConnectionText.setText("Waiting for Connection");

        String ip = ipTextField.getText();
        int port = Integer.parseInt(portTextField.getText());

        Thread clientListenerThread = new Thread(new ClientListener(port));
        clientListenerThread.start();

        PlayerConnection playerConnection = null;

        while(true) {
            try {
                playerConnection = new PlayerConnection(ip, port);
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

        changeStage("");
    }

    private void changeStage(String path){
        try {
        Stage stage = (Stage) waitingForConnectionText.getScene().getWindow();
        //load up OTHER FXML document
        Parent root = FXMLLoader.load(getClass().getResource("/FourInARowGame.fxml"));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

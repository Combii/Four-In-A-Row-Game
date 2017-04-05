package aPresentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    public Text waitingForConnectionText;
    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    @FXML
    void startGameClicked(ActionEvent event) {
        String ip = ipTextField.getText();
        String port = portTextField.getText();

        new Thread(() -> {
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
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

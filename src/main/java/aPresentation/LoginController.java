package aPresentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField ipTextField;

    @FXML
    private TextField portTextField;

    @FXML
    void startGameClicked(ActionEvent event) {
        String ip = ipTextField.getText();
        String port = portTextField.getText();
    }

}

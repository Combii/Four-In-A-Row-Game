import aPresentation.FourInARowGameController;
import aPresentation.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class RunProgram extends Application {

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Start.fxml"));
        LoginController.loader = loader;
        Parent root = loader.load();

        primaryStage.setTitle("Four In A Row");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

}

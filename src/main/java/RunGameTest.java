import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class RunGameTest extends Application {

    private static FXMLLoader loader;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        loader = new FXMLLoader(getClass().getResource("FourInARowGame.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Chat Program");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
}

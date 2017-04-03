package aPresentation;

import BusinessLogic.FourInARowList;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowGameController implements Initializable {
    public GridPane gridPane;

    private FourInARowList fourInARowList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setGridPane("pics");
    }

    private void setGridPane(FourInARowList fourInARowList) {
        gridPane.getChildren().clear();
        /*
        try {
            int rowCounter = 0, columnCounter = 0;


            for (final FilePath i : list.getList()) {

                Button button = new Button();

                //Handle when button is clicked on
                button.setOnAction(event -> {
                    try {
                        //https://stackoverflow.com/questions/5824916/how-do-i-open-an-image-in-the-default-image-viewer-using-java-on-windows
                        File file = new File(i.getLocalPath());
                        Desktop.getDesktop().open(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                File file = new File(i.getLocalPathThumbnail());
                String localUrl = file.toURI().toURL().toString();

                Image thumbnail = new Image(localUrl, false);
                ImageView view = new ImageView(thumbnail);
                view.setFitHeight(100);
                view.setFitWidth(150);
                button.setGraphic(view);
                gridPane.add(button, columnCounter, rowCounter);

                columnCounter++;
                if (columnCounter > 3) {
                    columnCounter = 0;
                    rowCounter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}

package aPresentation;

import BusinessLogic.CirclePiece;
import BusinessLogic.FourInARowList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowGameController implements Initializable {
    public GridPane gridPane;

    private FourInARowList fourInARowList;
    private String color = "Blue";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fourInARowList = new FourInARowList();
        setGridPane(fourInARowList);
    }

    private void setGridPane(FourInARowList fourInARowListClass) {
        gridPane.getChildren().clear();

        List<List<CirclePiece>> fourInARowList = fourInARowListClass.getFourInARowList();

        try {
            int rowCounter = 0, columnCounter = 0;
            //for()

            for (CirclePiece circlePiece : fourInARowList.get(rowCounter)) {

                Button button = new Button();

                //Handle when button is clicked on
                //Handle when button is clicked on
                button.setOnAction(event -> {
                    circlePiece.setColor(color);
                    System.out.println(circlePiece.getColor());
                });

                /*
                Image thumbnail = new Image(localUrl, false);
                ImageView view = new ImageView(thumbnail);
                view.setFitHeight(100);
                view.setFitWidth(150);
                button.setGraphic(view);
                */
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

    }
}

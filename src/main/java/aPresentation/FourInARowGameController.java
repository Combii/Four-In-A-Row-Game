package aPresentation;

import BusinessLogic.CirclePiece;
import BusinessLogic.FourInARowList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
            for(List<CirclePiece> circlePieceList : fourInARowList)

            for (CirclePiece circlePiece : circlePieceList) {

                Button button = new Button();
                Circle circle = new Circle(20, 20f, 19);

                //Handle when button is clicked on
                button.setOnAction(event -> {
                    circlePiece.setColor(Color.BLUE);
                    circle.setFill(circlePiece.getColor());
                });
                circle.setFill(Color.WHITE);

                button.setDisable(true);

                /*
                Image thumbnail = new Image(localUrl, false);
                ImageView view = new ImageView(thumbnail);
                view.setFitHeight(100);
                view.setFitWidth(150);
                */
                button.setGraphic(circle);

                gridPane.add(button, columnCounter, rowCounter);

                columnCounter++;
                if (columnCounter >= circlePieceList.size()) {
                    columnCounter = 0;
                    rowCounter++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

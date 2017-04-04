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
    private Color color = Color.BLUE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fourInARowList = new FourInARowList();
        setGridPane(fourInARowList);
    }

    private void setGridPane(FourInARowList fourInARowListClass) {
        gridPane.getChildren().clear();
        setGridPanePickColumnButtons();


        List<List<CirclePiece>> fourInARowList = fourInARowListClass.getFourInARowList();

        try {
            int rowCounter = 1, columnCounter = 0;
            for(List<CirclePiece> circlePieceList : fourInARowList)

            for (CirclePiece circlePiece : circlePieceList) {

                Button button = new Button();
                Circle circle = new Circle(20, 20f, 19);
                circle.setFill(circlePiece.getColor());

                /*
                //Handle when button is clicked on
                button.setOnAction(event -> {
                    circlePiece.setColor(color);
                    circle.setFill(circlePiece.getColor());
                });
                */

                //button.fire();
                button.setDisable(true);
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

    private void setGridPanePickColumnButtons(){
        try {
            int rowCounter = 0, columnCounter = 0;

            while(columnCounter != 7) {
                Button button = new Button();

                //Handle when button is clicked on
                int finalColumnCounter = columnCounter;
                button.setOnAction(event -> {
                    fourInARowList.setBrick(finalColumnCounter, color);
                    setGridPane(fourInARowList);

                });
                button.setText("Place");


                gridPane.add(button, columnCounter, rowCounter);

                columnCounter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //This is only for prettier GUI view
        gridPane.requestFocus();
    }

}

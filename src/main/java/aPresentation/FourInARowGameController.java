package aPresentation;

import BusinessLogic.Client.ClientListener;
import BusinessLogic.Client.PlayerConnection;
import BusinessLogic.TheGame.CirclePiece;
import BusinessLogic.TheGame.FourInARowList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class FourInARowGameController implements Initializable {
    public GridPane gridPane;
    public Text announcingText;

    public static FourInARowList fourInARowList;
    public Text usernameText;
    private Color color = ClientListener.colorChosen;

    public static boolean waitForTurn;
    public static boolean gameOver = false;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(color.equals(Color.RED))
            waitForTurn = true;

        fourInARowList = new FourInARowList();
        setGridPane(fourInARowList);
    }

    public void setGridPane(FourInARowList fourInARowListClass) {
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

                while (columnCounter != 7) {
                    Button button = new Button();

                    //Handle when button is clicked on
                    int finalColumnCounter = columnCounter;
                    button.setOnAction(event -> {
                        boolean wincheck = fourInARowList.setBrick(finalColumnCounter, color);

                        if(wincheck)
                            stopGame("You Won!");

                        waitForTurn = true;

                        try {
                            new PlayerConnection().sendObject("CIRCLESELECTED: " + finalColumnCounter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        setGridPane(fourInARowList);
                    });
                    button.setText("Place");

                    if(!gameOver) {
                        if (waitForTurn) {
                            button.setDisable(true);
                            announcingText.setText("Your opponent's turn");
                        } else
                            announcingText.setText("It's your turn");
                    }

                    gridPane.add(button, columnCounter, rowCounter);

                    columnCounter++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //This is only for prettier GUI view
        gridPane.requestFocus();

    }

    public void stopGame(String winOrLostMessage){
        announcingText.setText(winOrLostMessage);
        waitForTurn = true;
        gameOver = true;
    }
}

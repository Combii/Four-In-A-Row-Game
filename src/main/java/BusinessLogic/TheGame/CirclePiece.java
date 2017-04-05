package BusinessLogic.TheGame;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece implements Serializable{

    private Color color;
    private final int row;
    private final int column;

    public CirclePiece(Color color, int row, int column) {

        this.color = color;
        this.row = row;
        this.column = column;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.toString();
    }


}

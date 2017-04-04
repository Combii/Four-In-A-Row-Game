package BusinessLogic.TheGame;

import javafx.scene.paint.Color;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece {
    /**
     * This will probably be changed to x and y position of CirclePiece
     */
    private Color color;
    private int row;
    private int column;

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

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return color.toString();
    }
}

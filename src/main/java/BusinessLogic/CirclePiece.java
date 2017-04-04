package BusinessLogic;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece implements Serializable{

    private final int x;
    private final int y;
    private Color color;



    public CirclePiece(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.toString();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

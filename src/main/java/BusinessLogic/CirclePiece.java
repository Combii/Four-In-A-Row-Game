package BusinessLogic;

import javafx.scene.paint.Color;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece {
    private Color color;

    public CirclePiece(Color color) {
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
}

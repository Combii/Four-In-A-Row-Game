package BusinessLogic;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece {
    private String Color;

    public CirclePiece(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }

    @Override
    public String toString() {
        return Color;
    }
}

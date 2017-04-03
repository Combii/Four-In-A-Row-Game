package BusinessLogic;

/**
 * Created by David Stovlbaek
 * 03 April 2017.
 */
public class CirclePiece {
    private String Color;
    private boolean isPicked;

    public CirclePiece(String color, boolean isPicked) {
        Color = color;
        this.isPicked = isPicked;
    }

    public String getColor() {
        return Color;
    }

    public boolean isPicked() {
        return isPicked;
    }
}

package gameplay;

public class ColorBox extends Box {

    enum Color {
        YELLOW, ORANGE, RED, GREEN, BLUE, PINK
    }

    Color c;

    public Color getColor() {
        return this.c;
    }
}

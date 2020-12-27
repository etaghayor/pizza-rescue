package media;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fonts {

    private static Font blueberryFont;

    public static Font getBlueberryFont() {
        if (blueberryFont == null) {
            try {
                //create the font to use. Specify the size!
                blueberryFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Blueberry.ttf")).deriveFont(30f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //register the font
                ge.registerFont(blueberryFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
        return blueberryFont;
    }
}

package media;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Fonts {

    private static Font blueberryFont, blueberrySmallFont, cevicheFont;

    public static Font getBlueberryFont() {
        if (blueberryFont == null) {
            try {
                //create the font to use. Specify the size!
                blueberryFont = Font.createFont(Font.TRUETYPE_FONT, new File("../resources/fonts/Blueberry.ttf")).deriveFont(30f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //register the font
                ge.registerFont(blueberryFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
        return blueberryFont;
    }

    public static Font getBlueberrySmallFont() {
        if (blueberrySmallFont == null) {
            try {
                //create the font to use. Specify the size!
                blueberrySmallFont = Font.createFont(Font.TRUETYPE_FONT, new File("../resources/fonts/Blueberry.ttf")).deriveFont(20f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //register the font
                ge.registerFont(blueberrySmallFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
        return blueberrySmallFont;
    }

    public static Font getCevicheFont() {
        if (cevicheFont == null) {
            try {
                //create the font to use. Specify the size!
                cevicheFont = Font.createFont(Font.TRUETYPE_FONT, new File("../resources/fonts/CevicheOne-Regular.ttf")).deriveFont(34f);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //register the font
                ge.registerFont(cevicheFont);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        }
        return cevicheFont;
    }

}

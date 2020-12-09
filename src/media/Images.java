package media;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Images {
    private static BufferedImage backgroundImage;
    private static BufferedImage yellowBoxImage, redBoxImage;

    public static Image getBackgroundImage() {
        if (backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("images/Background2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return backgroundImage;
    }

    public static BufferedImage getRedBoxImage() {
        if (redBoxImage == null) {
            try {
                redBoxImage = ImageIO.read(new File("images/red2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return redBoxImage;
    }
}

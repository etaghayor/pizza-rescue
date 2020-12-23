package media;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// This class stockes all of our images : backgroundImages, fruitsBoxImages, pizzaImage
// With this way, we only have to call getMyImage() function to access to our images
public class Images {
    private static BufferedImage backgroundImage;
    private static Image yellowBoxImage, redBoxImage, blueBoxImage, pinkBoxImage, greenBoxImage, orangeBoxImage;
    private static Image pizzaImage, obstacleImage;

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

    public static Image getRedBoxImage() {
        if (redBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/red.png"));
                redBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return redBoxImage;
    }

    public static Image getBlueBoxImage() {
        if (blueBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/blue.png"));
                blueBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return blueBoxImage;
    }

    public static Image getYellowBoxImage() {
        if (yellowBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/yellow.png"));
                yellowBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return yellowBoxImage;
    }

    public static Image getPinkBoxImage() {
        if (pinkBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/pink.png"));
                pinkBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return pinkBoxImage;
    }

    public static Image getGreenBoxImage() {
        if (greenBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/green.png"));
                greenBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return greenBoxImage;
    }

    public static Image getOrangeBoxImage() {
        if (orangeBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/orange.png"));
                orangeBoxImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return orangeBoxImage;
    }

    public static Image getPizzaImage() {
        if (pizzaImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/pizza.png"));
                pizzaImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return pizzaImage;
    }

    public static Image getObstacleImage() {
        if (obstacleImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("images/obstacle.jpg"));
                obstacleImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return obstacleImage;
    }
}

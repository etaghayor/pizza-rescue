package media;

import javax.imageio.ImageIO;
import javax.swing.*;
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
    private static ImageIcon gearImage, musicImage, musicOffImage, backImage;
    private static Icon avocadoImage, appleImage;
    private static Image woodImage, smallWoodImage;
    private static Image aboutUsTextImage;
    private static Icon woodButtonIcon, woodLevelIcon, greyWoodLevelIcon, smallWoodIcon;

    public static Image getBackgroundImage() {
        if (backgroundImage == null) {
            try {
                backgroundImage = ImageIO.read(new File("resources/images/Background2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return backgroundImage;
    }

    public static Image getRedBoxImage() {
        if (redBoxImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("resources/images/red.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/blue.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/yellow.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/pink.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/green.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/orange.png"));
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
                BufferedImage tmp = ImageIO.read(new File("resources/images/pizza.png"));
                pizzaImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return pizzaImage;
    }

    public static ImageIcon getGearImage() {
        if (gearImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/gear.png"));
                tmp = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                gearImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return gearImage;
    }

    public static ImageIcon getMusicOffImage() {
        if (musicOffImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/musicoff.png"));
                tmp = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                musicOffImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return musicOffImage;
    }

    public static ImageIcon getMusicImage() {
        if (musicImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/music.png"));
                tmp = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                musicImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return musicImage;
    }

    public static ImageIcon getBackImage() {
        if (backImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/backButton.png"));
                tmp = tmp.getScaledInstance(57, 57, Image.SCALE_SMOOTH);
                backImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return backImage;
    }

    public static Image getObstacleImage() {
        if (obstacleImage == null) {
            try {
                BufferedImage tmp = ImageIO.read(new File("resources/images/obstacle.jpg"));
                obstacleImage = tmp.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return obstacleImage;
    }

    public static Icon getAppleImage() {
        if (appleImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/apple.png"));
                tmp = tmp.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                appleImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return appleImage;
    }

    public static Icon getAvocadoImage() {
        if (avocadoImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/avocado.png"));
                tmp = tmp.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
                avocadoImage = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return avocadoImage;
    }

    public static Icon getWoodIcon() {
        if (woodButtonIcon == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/wood.png"));
                tmp = tmp.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
                woodButtonIcon = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return woodButtonIcon;
    }


    public static Icon getSmallWoodIcon() {
        if (smallWoodIcon == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/woodLevel.png"));
                tmp = tmp.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                smallWoodIcon = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return smallWoodIcon;
    }

    public static Image getWoodImage() {
        if (woodImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/wood.png"));
                woodImage = tmp.getScaledInstance(660, 100, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return woodImage;
    }

    public static Icon getWoodLevelIcon() {
        if (woodLevelIcon == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/woodLevel.png"));
                tmp = tmp.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                woodLevelIcon = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return woodLevelIcon;
    }

    public static Icon getGreyWoodLevelIcon() {
        if (greyWoodLevelIcon == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/greyWoodLevel.png"));
                tmp = tmp.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
                greyWoodLevelIcon = new ImageIcon(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return greyWoodLevelIcon;
    }

    public static Image getAboutUsTextImage() {
        if (aboutUsTextImage == null) {
            try {
                Image tmp = ImageIO.read(new File("resources/images/about_us.png"));
                aboutUsTextImage = tmp.getScaledInstance(669, 639, Image.SCALE_SMOOTH);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return aboutUsTextImage;
    }
}

package FlappyBird.gameUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

/*
    Load Game Static Assets Util
*/
public class GameUtil
{
    // Load Game Buffered Images
    public static BufferedImage loadBufferedImage(String imagePath)
    {
        try
        {
            return ImageIO.read(new FileInputStream(imagePath));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
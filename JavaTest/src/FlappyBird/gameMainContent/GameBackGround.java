package FlappyBird.gameMainContent;

import FlappyBird.gameUtil.GameUtil;
import static FlappyBird.gameUtil.GameConst.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Draw Game Frame Background
*/
public class GameBackGround
{
    // Game Background Image
    private BufferedImage bufferedImage;

    // Construct Background Assets Image
    public GameBackGround()
    {
        bufferedImage = GameUtil.loadBufferedImage(BACK_IMAGE_PATH);
    }

    // Draw Game Images Assets
    public void drawGameImages(Graphics graphics)
    {
        /*
            Draw order: background color -> background image
        */
        // Draw Background Color
        graphics.setColor(BACK_GROUND_COLOR);
        graphics.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        graphics.setColor(Color.black);

        // Get Image Width And Height
        int image_Width = bufferedImage.getWidth();
        int image_Height = bufferedImage.getHeight();

        // Set Draw Background For Loop Count
        int drawBackImageCount = (FRAME_WIDTH / image_Width) + 1;
        for (int i = 0; i < drawBackImageCount; ++i)
        {
            // Draw Back Image In Frame Window
            graphics.drawImage(bufferedImage, image_Width * i, FRAME_HEIGHT - image_Height, null);
        }
    }
}
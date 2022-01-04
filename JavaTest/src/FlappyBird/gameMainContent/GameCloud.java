package FlappyBird.gameMainContent;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Game Cloud Setting
*/
public class GameCloud
{
    // Cloud Size
    private static final int CLOUD_WIDTH = 144;

    // Cloud Image
    private BufferedImage cloudBufferImage;

    // Cloud Move Speed
    private int cloudMoveSpeed;

    // Cloud Generate Location In GameMainFrame
    private int cloudGenerate_X;
    private int cloudGenerate_Y;

    // init Cloud
    public GameCloud(BufferedImage cloudBufferImage, int cloudMoveSpeed, int cloudGenerate_X, int cloudGenerate_Y)
    {
        this.cloudBufferImage = cloudBufferImage;
        this.cloudMoveSpeed = cloudMoveSpeed;
        this.cloudGenerate_X = cloudGenerate_X;
        this.cloudGenerate_Y = cloudGenerate_Y;
    }

    // Draw Cloud In Game: <Location, Speed>
    public void drawCloud(Graphics cloudGraphic)
    {
        cloudGenerate_X -= cloudMoveSpeed;
        cloudGraphic.drawImage(cloudBufferImage, cloudGenerate_X, cloudGenerate_Y, null);
    }

    // Judge Cloud Is Level Frame Window
    public boolean isCloudLevelFrameWindow()
    {
        return cloudGenerate_X < -CLOUD_WIDTH;
    }
}
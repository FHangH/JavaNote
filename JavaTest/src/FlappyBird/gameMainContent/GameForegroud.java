package FlappyBird.gameMainContent;

import FlappyBird.gameUtil.GameUtil;
import static FlappyBird.gameUtil.GameConst.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/*
    GameForegroud Setting: <GameCloud>
*/
public class GameForegroud
{
    // Clouds Nums
    private static final int CLOUD_COUNT = 2;

    // Clouds Container
    private ArrayList<GameCloud> cloudlist;

    // Clouds Move Speed
    private static final int CLOUD_MOVE_SPEED = 1;

    // Clouds Images
    BufferedImage[] cloudBufferedImages;

    // Define Clouds Random Generate
    private Random cloudsRandom;

    // init GameForegroud
    public GameForegroud()
    {
        cloudlist = new ArrayList<>();
        cloudBufferedImages = new BufferedImage[CLOUD_COUNT];

        // Load Clouds Buffered Images
        for (int i = 0; i < CLOUD_COUNT; ++i)
        {
            cloudBufferedImages[i] = GameUtil.loadBufferedImage(CLOUD_IMAGES_PATH[i]);
        }

        // new Random
        cloudsRandom = new Random();
    }

    // Draw Clouds
    public void drawClouds(Graphics cloudsGraphics)
    {
        generateCloudsLogic();  

        for (GameCloud gameCloud : cloudlist)
        {
            gameCloud.drawCloud(cloudsGraphics);
        }
    }

    // Control Generate Clouds Count Logic
    public void generateCloudsLogic()
    {
        if ((int)(Math.random() * FRAME_HEIGHT) < 2)
        {
            GameCloud gameCloud = new GameCloud
                    (
                            cloudBufferedImages[cloudsRandom.nextInt(CLOUD_COUNT)],
                            CLOUD_MOVE_SPEED, FRAME_WIDTH, cloudsRandom.nextInt(FRAME_WIDTH / 2)
                    );
            cloudlist.add(gameCloud);
        }

        for (int i = 0; i < cloudlist.size(); ++i)
        {
            if (cloudlist.get(i).isCloudLevelFrameWindow())
            {
                cloudlist.remove(i);
                --i;
                System.out.println("Remove Cloud");
            }
        }
    }
}
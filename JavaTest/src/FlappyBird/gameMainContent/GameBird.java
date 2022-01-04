package FlappyBird.gameMainContent;

import static FlappyBird.gameUtil.GameConst.*;
import FlappyBird.gameUtil.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Game Bird Setting
*/
public class GameBird
{
    // Bird Image -> <Up, Normal, Down>
    public static final int BIRD_IMAGES_COUNT = 3;
    private BufferedImage[] birdBuffImages;

    // Define Bird Default Location
    private int birdLocation_X = 100;
    private int birdLocation_Y = 100;

    // Define Bird Self Image Height: (Up Turn Down)
    public static final int BIRD_SELF_HEIGHT = 40;

    // Define Bird States: <Normal, Up, Down>
    private int birdStates;
    public static final int BIRD_STATES_NORMAL = 0;
    public static final int BIRD_STATES_UP = 1;
    public static final int BIRD_STATES_DOWN = 2;

    // Define Bird Move(Fly) Direction: <Up, Down>
    private boolean isFlyUp = false;
    private boolean isFlyDown = false;

    // Define Bird Acceleration
    private int acceleration;

    // Define Bird Rect Collision Box
    private Rectangle birdRectCollision;
    private int rect_Width;
    private int rect_Height;

    // Define Bird Life
    public boolean isBirdLife;

    // init Bird
    public GameBird()
    {
        // init Bird Images
        birdBuffImages = new BufferedImage[BIRD_IMAGES_COUNT];
        for (int i = 0; i < BIRD_IMAGES_COUNT; ++i)
        {
            birdBuffImages[i] = GameUtil.loadBufferedImage(BIRD_IMAGES_PATH[i]);
        }

        // Init bird life
        isBirdLife = true;

        // init bird rect ccllision box
        rect_Width = birdBuffImages[0].getWidth();
        rect_Height = birdBuffImages[0].getHeight();
        birdRectCollision = new Rectangle(rect_Width, rect_Height);
    }

    // Getter And Setter
    public Rectangle getBirdRectCollision() {return birdRectCollision;}

    // Draw Bird In Game: Bird Default <Loaction, States, flyLogic, rectBox>
    public void drawBird(Graphics birdGraphics)
    {
        birdFlyDirectionLogic();
        birdGraphics.drawImage(birdBuffImages[birdStates], birdLocation_X, birdLocation_Y, null);

        // draw bird rect collision box
        /*birdGraphics.drawRect(birdLocation_X, birdLocation_Y, birdRectCollision.width, birdRectCollision.height);*/
        birdRectCollision.x = birdLocation_X;
        birdRectCollision.y = birdLocation_Y;
    }

    // Change Bird Fly <Direction>
    public void birdFlyDirectionLogic()
    {
        if (isFlyUp)
        {
            --acceleration;
            birdLocation_Y += acceleration;
            if (acceleration < -2)
            {
                acceleration = -2;
            }
            if (birdLocation_Y < BIRD_SELF_HEIGHT / 2)
            {
                birdLocation_Y = BIRD_SELF_HEIGHT / 2;
                acceleration = 0;
            }
        }
        if (isFlyDown)
        {
            ++acceleration;
            birdLocation_Y += acceleration;
            if (acceleration > 2)
            {
                acceleration = 2;
            }
            if (birdLocation_Y > FRAME_HEIGHT - BIRD_SELF_HEIGHT)
            {
                birdLocation_Y = FRAME_HEIGHT - BIRD_SELF_HEIGHT;
                acceleration = 0;
            }
        }
    }

    // Change Bird Fly <States>
    public void changeBirdFlyStates(int birdFlyStates)
    {
        switch (birdFlyStates)
        {
            case BIRD_STATES_NORMAL ->
            {
                birdStates = BIRD_STATES_NORMAL;
                isFlyUp = false;
                isFlyDown = false;
            }
            case BIRD_STATES_UP ->
            {
                birdStates = BIRD_STATES_UP;
                isFlyUp = true;
                isFlyDown = false;
            }
            case BIRD_STATES_DOWN ->
            {
                birdStates = BIRD_STATES_DOWN;
                isFlyUp = false;
                isFlyDown = true;
            }
        }
    }

    // Game Over Restart Draw GameBird Location In Game Frame
    public void restartDrawBird()
    {
        isBirdLife = true;
        birdLocation_X = 100;
        birdLocation_Y = 100;
    }
}
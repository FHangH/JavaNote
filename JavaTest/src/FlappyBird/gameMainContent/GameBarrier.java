package FlappyBird.gameMainContent;

import FlappyBird.gameUtil.GameUtil;
import static FlappyBird.gameUtil.GameConst.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Barrier Setting
*/
public class GameBarrier
{
    // Barrier Buffered Images
    private static final BufferedImage[] barrierBufferedIamges;

    // Barrier Right To Left Move Speed
    private static final int BARRIER_MOVE_SPEED = 3;

    // Barrier Instance States
    private boolean isBarrierVisible;

    // Define Barrier Rect Collision Box
    private Rectangle barrierRectCollision;

    // Static Init Barriers
    static
    {
        // A barrier == 3 images component
        final int BARRIER_COUNT = 3;
        barrierBufferedIamges = new BufferedImage[BARRIER_COUNT];
        for (int i = 0; i < BARRIER_COUNT; ++i)
        {
            barrierBufferedIamges[i] = GameUtil.loadBufferedImage(BARRIER_IMAGES_PATH[i]);
        }
    }

    // Barrier generate <location, width, height>
    private int barrierLocation_X, barrierLocation_Y;
    private int barrierHeight;

    // Barrier Define Type
    // barrier_normal_top == barrier_turnDown ....
    private int barrierType;
    public static final int BARRIER_TYPE_NORMAL_TOP = 0;
    public static final int BARRIER_TYPE_NORMAL_BOTTOM = 2;

    /*
        Get Barrier images: <Width, Height>
    */
    // Barrier Normal
    public static final int BARRIER_NORMAL_WIDTH = barrierBufferedIamges[0].getWidth();
    public static final int BARRIER_NORMAL_HEIGHT = barrierBufferedIamges[0].getHeight();
    // Barrier head: <Top, Down>
    public static final int BARRIER_HEAD_WIDTH = barrierBufferedIamges[1].getWidth();
    public static final int BARRIER_HEAD_HEIGHT = barrierBufferedIamges[1].getHeight();

    // Init Barrier <Normal, Up, Down, barrierCollision>
    public GameBarrier()
    {
        // init rect barrier collision box
        barrierRectCollision = new Rectangle();
    }

    /*
        Getter and Setter barrier In Pool: <location_X, location_Y, Height, Type>
    */

    public void setBarrierLocation_X(int barrierLocation_X)
    {
        this.barrierLocation_X = barrierLocation_X;
    }

    public void setBarrierLocation_Y(int barrierLocation_Y)
    {
        this.barrierLocation_Y = barrierLocation_Y;
    }

    public void setBarrierHeight(int barrierHeight)
    {
        this.barrierHeight = barrierHeight;
    }

    public void setBarrierType(int barrierType)
    {
        this.barrierType = barrierType;
    }

    public boolean isBarrierVisible()
    {
        return isBarrierVisible;
    }
    public void setBarrierVisible(boolean visible) {isBarrierVisible = visible;}

    public Rectangle getBarrierRectCollision() {return barrierRectCollision;}

    /*
                Draw Barrier component in Buffered: <location, width, height, type>
                Draw Barrier Type: <barrier_normal, barrier_head>
            */
    public void drawBarrier(Graphics barrierGraphics)
    {
        switch (barrierType)
        {
            case BARRIER_TYPE_NORMAL_TOP -> drawBarrierTurnDown(barrierGraphics);
            case BARRIER_TYPE_NORMAL_BOTTOM -> drawBarrierTurnUp(barrierGraphics);
        }
    }

    /*
        judge barrier is out Frame
        IF out frame -> change barrier states
    */
    public void isBarrierOutFrame()
    {
        if (barrierLocation_X < -26)
        {
            setBarrierVisible(false);
        }
    }

    /*
        Draw TurnDown Barrier
    */
    public void drawBarrierTurnDown(Graphics barrier_TurnDown_Graphics)
    {
        // Note Barrier Need barrier_normal nums
        int needBarrierNormalCount = (barrierHeight - BARRIER_HEAD_WIDTH) / BARRIER_NORMAL_HEIGHT + 1;

        // Draw barrier_TurnDown_normal
        for (int i = 0; i < needBarrierNormalCount; ++i)
        {
            barrier_TurnDown_Graphics.drawImage
                    (
                            barrierBufferedIamges[0],
                            barrierLocation_X, barrierLocation_Y + (i * BARRIER_NORMAL_HEIGHT), null
                    );
        }

        // Draw barrier_TurnDown_head
        int barrierHead_Y = barrierHeight - BARRIER_HEAD_HEIGHT;
        barrier_TurnDown_Graphics.drawImage
                (
                        barrierBufferedIamges[2],
                        barrierLocation_X - (BARRIER_HEAD_WIDTH - BARRIER_NORMAL_WIDTH) / 2, barrierHead_Y, null
                );

        // Barrier Move in Frame
        barrierLocation_X -= BARRIER_MOVE_SPEED;

        // Draw Barrier Rect
        drawBarrierRect(/*barrier_TurnDown_Graphics*/);

        // judge barrier is out Frame
        isBarrierOutFrame();
    }

    /*
        Draw TurnTop Barrier
    */
    public void drawBarrierTurnUp(Graphics barrier_TurnUp_Graphics)
    {
        // Note Barrier Need barrier_normal nums
        int needBarrierNormalCount = (barrierHeight / BARRIER_NORMAL_HEIGHT) + 1;

        // Draw barrier_TurnUp_normal
        for (int i = 0; i < needBarrierNormalCount; ++i)
        {
            barrier_TurnUp_Graphics.drawImage
                    (
                            barrierBufferedIamges[0],
                            barrierLocation_X, FRAME_HEIGHT - (i * BARRIER_NORMAL_HEIGHT), null
                    );

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            barrierLocation_Y = FRAME_HEIGHT - (i * BARRIER_NORMAL_HEIGHT);
        }

        // Draw barrier_TurnUp_head
        int barrierHead_Y = FRAME_HEIGHT - barrierHeight;
        barrier_TurnUp_Graphics.drawImage
                (
                        barrierBufferedIamges[1],
                        barrierLocation_X - (BARRIER_HEAD_WIDTH - BARRIER_NORMAL_WIDTH) / 2, barrierHead_Y, null
                );

        // Barrier Move in Frame
        barrierLocation_X -= BARRIER_MOVE_SPEED;

        // Draw Barrier Rect
        drawBarrierRect(/*barrier_TurnUp_Graphics*/);

        // judge barrier is out Frame
        isBarrierOutFrame();
    }

    // Judge next group Barriers enter GameFrame Window
    public boolean isBarriersCanInFrame()
    {
        return FRAME_WIDTH - barrierLocation_X > 150;
    }

    // Draw barrier rect collision box
    public void drawBarrierRect(/*Graphics barrierGraphics*/)
    {
        int rect_X = this.barrierLocation_X;
        int rect_Y = this.barrierLocation_Y;
        int rect_Width = barrierBufferedIamges[0].getWidth();
        int rect_Height = barrierHeight;

        // Debug barrier collision box color
        /*barrierGraphics.setColor(Color.blue);*/
        /*barrierGraphics.drawRect(rect_X, rect_Y, rect_Width, rect_Height);*/

        setBarrierRectAngle(rect_X, rect_Y, rect_Width, rect_Height);
    }

    // Barrier Rect Collision Box Value Setting
    public void setBarrierRectAngle(int rect_X, int rect_Y, int rect_Width, int rect_Height)
    {
        barrierRectCollision.x = rect_X;
        barrierRectCollision.y = rect_Y;
        barrierRectCollision.width = rect_Width;
        barrierRectCollision.height = rect_Height;
    }
}
package FlappyBird.gameUtil;

import java.awt.*;

/*
    Game Main Window Const Default Setting
*/
public class GameConst
{
    /*
        Game Frame Assets Path
    */
    // Game Frame Icon Path
    public static final String FRAME_ICON_PATH = "src\\FlappyBird\\imageAssets\\fh.jpg";
    // Background Image Path
    public static final String BACK_IMAGE_PATH = "src\\FlappyBird\\imageAssets\\background_Land.png";
    // Game Bird Images Path
    public static final String[] BIRD_IMAGES_PATH =
            {
                    "src\\FlappyBird/imageAssets\\bird_normal.png",
                    "src\\FlappyBird/imageAssets\\bird_up.png",
                    "src\\FlappyBird/imageAssets\\bird_down.png"
            };
    // Game Clouds Images Path
    public static final String[] CLOUD_IMAGES_PATH =
            {
                    "src\\FlappyBird\\imageAssets\\cloud_1.png",
                    "src\\FlappyBird\\imageAssets\\cloud_2.png"
            };
    // Game Barriers Images Path
    public static final String[] BARRIER_IMAGES_PATH =
            {
                    "src\\FlappyBird\\imageAssets\\barrier.png",
                    "src\\FlappyBird\\imageAssets\\barrier_TurnUp.png",
                    "src\\FlappyBird\\imageAssets\\barrier_TurnDown.png"
            };
    // Game Score Info Page Path
    public static final String GAME_SCORE_INFO_FILE = "src\\FlappyBird\\gameInfo";

    // Game Frame ToolKit For (Frame Icon)
    public static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();

    // Game Frame Size Const
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 500;

    // Game Frame Icon
    public static final Image GAME_ICON = TOOLKIT.getImage(FRAME_ICON_PATH);

    // Game Frame Title
    public static final String FRAME_TITLE = "FH_FlappyBird";

    // Game Frame Default Location X Y => Window Center
    private static final Point CENTER_POINT = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    public static final int FRAME_X = CENTER_POINT.x - (FRAME_WIDTH / 2);
    public static final int FRAME_Y = CENTER_POINT.y- (FRAME_HEIGHT / 2);

    // Game BackGround Color
    public static final Color BACK_GROUND_COLOR = new Color(0x4B4CF);

    // Game Refresh Frames per Second (Nearly)
    // 1s 60 frames == 0.01666....
    public static final int FRAMES_SECOND_60 = 16;
    /*public static final int FRAMES_SECOND_30 = 33;*/
}
package FlappyBird.gameMainContent;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static FlappyBird.gameUtil.GameConst.*;

/*
    Draw Game Main Frame
*/
public class FlappyBirdFrame extends Frame
{
    /*
        Instance Game Object: <background, bird, foregroud, barrierlayer>
    */
    // Instance GameBackGround
    private GameBackGround gameBackGround;
    // Instance GameBird
    private GameBird gameBird;
    // Instance GameForegroud
    private GameForegroud gameForegroud;
    // Instance GameBarrierLayer
    private GameBarrierLayer gameBarrierLayer;

    // Leave With Image Property
    private BufferedImage bufferedImage = new BufferedImage(FRAME_WIDTH, FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

    // Init Default Value
    public FlappyBirdFrame()
    {
        // Set Frame Visible
        setVisible(true);

        // Set Frame Size == 600 * 500
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Set Frame Icon
        setIconImage(GAME_ICON);

        // Set Frame Title
        setTitle(FRAME_TITLE);

        // Set Frame Window Default Location(Bounds) In Screen Center
        setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);

        // Set Frame Size Can not Change
        setResizable(false);

        // Add Frame Window Close WindowListener_Event
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                super.windowClosing(e);

                // Exit Game Frame Window
                System.exit(0);
            }
        });

        // Transfer initGameObject
        // First Instance Game Frame Window, Later Instance GameBackground, GameBird
        initGameObject();

        // Use Graphics Thread To Safe Repaint Graphics Component
        new Run().start();

        // Add KeyListener: Let Bird Listener KeyBorad Input Execute KeyEvents
        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                addFlySpeed(e);
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                super.keyReleased(e);
                minuFlySpeed(e);
            }
        });
    }

    // Init Game Object
    public void initGameObject()
    {
        gameBackGround = new GameBackGround();
        gameBird = new GameBird();
        gameForegroud = new GameForegroud();
        gameBarrierLayer = new GameBarrierLayer();
    }

    /*
        Java auto check graphics component is LightWeight Or HeavyWeight;
        IF LightWeight, Graphics Thread Transfer repaint() ==> Is System Drive Safe Function
            -- Because Application need first transfer repaint() -> update() -> paint()
    */
    // Create Predicate To Override Thread run() Function
    class Run extends Thread
    {
        @Override
        public void run()
        {
            while (true)
            {
                // Re_Paint Graphics Component
                repaint();

                // Nearly Repaint 60 frames per second
                // 1s 60 frames == 0.01666....
                try
                {
                    Thread.sleep(FRAMES_SECOND_60);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
        Each update draws the pictures of the respective objects to the buffer pool,
        Then draws them to the screen together;
    */
    // Draw all Game content -> Default
    // Draw order: <Backgroud -> foreground -> bird>
    @Override
    public void update(Graphics allGraphics)
    {
        // judge Bird is life
        if (gameBird.isBirdLife)
        {
            Graphics newGraphics = bufferedImage.getGraphics();
            // Draw All Content In this newGraphics
            gameBackGround.drawGameImages(newGraphics);
            gameForegroud.drawClouds(newGraphics);
            gameBird.drawBird(newGraphics);
            gameBarrierLayer.drawBarriersInLayer(newGraphics, gameBird);

            // Last Draw In Screen
            allGraphics.drawImage(bufferedImage, 0, 0, null);

            // @CopyRight
            String copyright = "@Copyright: 方皓 82104322004";
            allGraphics.setColor(Color.white);
            allGraphics.setFont(new Font("宋体", Font.BOLD, 20));
            allGraphics.drawString(copyright, 285, 485);
        }
        else
        {
            String gameOver = "Game Over";
            allGraphics.setColor(Color.red);
            allGraphics.setFont(new Font("JetBrains Mono", Font.BOLD, 60));
            allGraphics.drawString(gameOver, 150, 250);

            String restartMessage = "<- Space Key Rstart ->";
            allGraphics.setColor(Color.white);
            allGraphics.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
            allGraphics.drawString(restartMessage, 170, 350);
        }
    }

    /*
        Set KeyEvent Bind GameBird Object
            -- keyPressed, keyReleased

        Game Over
            -- Listener SpaceKey to Restart Game
    */
    // KeyPressed
    public void addFlySpeed(KeyEvent event)
    {
        switch (event.getKeyCode())
        {
            case KeyEvent.VK_UP -> gameBird.changeBirdFlyStates(GameBird.BIRD_STATES_UP);
            case KeyEvent.VK_SPACE ->
                    {
                        if (!gameBird.isBirdLife)
                        {
                            restartGame();
                        }
                    }
        }
    }

    // KeyReleased
    public void minuFlySpeed(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_DOWN)
        {
            gameBird.changeBirdFlyStates(GameBird.BIRD_STATES_DOWN);
        }
    }

    // Game Over Restart Game
    public void restartGame()
    {
        gameBarrierLayer.clearBarriersPool();
        gameBird.restartDrawBird();
    }
}
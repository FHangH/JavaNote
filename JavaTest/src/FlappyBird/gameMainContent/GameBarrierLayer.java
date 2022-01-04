package FlappyBird.gameMainContent;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static FlappyBird.gameUtil.GameConst.*;

/*
    BarrierLayer Setting
*/
public class GameBarrierLayer
{
    // Random generate
    private Random barriersRandom = new Random();

    // Barriers Container
    private List<GameBarrier> gameBarrierList;

    // Random Generate barrierTurnDown Height
    private int turnDownRandomHeight;
    // Random Generate barrierTurnUp Height
    private int turnUpRandomHeight;

    // Instance Timer
    private GameTimer gameTimer;

    // Define Game Score Info File
    private File gameFile;
    // Define GameInfo Text
    private int gameInfoText;

    // Init GameBarrierLayer
    public GameBarrierLayer()
    {
        gameBarrierList = new ArrayList<>();
        gameTimer = new GameTimer();
        gameFile = new File(GAME_SCORE_INFO_FILE);
    }

    // Draw Barriers in BarrierLayer to show GameFrame Window
    public void drawBarriersInLayer(Graphics barriersLayerGraphics, GameBird gameBird)
    {
        for (int i = 0; i < gameBarrierList.size(); ++i)
        {
            GameBarrier gameBarrier = gameBarrierList.get(i);

            // Judge Barrier is in Frame
            // IF True -> draw barrier
            if (gameBarrier.isBarrierVisible())
            {
                gameBarrier.drawBarrier(barriersLayerGraphics);
            }
            else
            {
                GameBarrier needRemoveBarrier = gameBarrierList.remove(i);
                GameBarrierPool.returnToBarriersPool(needRemoveBarrier);
                --i;
            }
        }

        barrierLayerGenerateLogic(barriersLayerGraphics);

        isCollisionBird(gameBird);
    }

    // barriersLayer generate Direction: Right to Left
    public void barrierLayerGenerateLogic(Graphics graphics)
    {
        if (gameBarrierList.isEmpty())
        {
            randomBarriersHeight();

            // Transfer Timer
            gameTimer.startTime();

            insertBarrierInPool(600, 0, turnDownRandomHeight, 0);
            insertBarrierInPool(600, 400 - turnUpRandomHeight, turnUpRandomHeight, 2);
        }
        else
        {
            // Transfer Timer
            long timeDiff = gameTimer.difference();
            graphics.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
            graphics.setColor(Color.white);
            graphics.drawString("Score: " + timeDiff, 10, 50);

            /*
                Update Game Score Info
            */
            // judge Current Game score is greater origin Game score
            // IF -> Override GameInfo Text
            gameInfoText = getTextInfo();
            if (timeDiff <= gameInfoText)
            {
                graphics.drawString("Max Score: " + gameInfoText, 10, 75);
            }
            else
            {
                setTextInfo(String.valueOf(timeDiff));
                graphics.drawString("Max Score: " + getTextInfo(), 10, 75);
            }

            // Judge Current Group barries the last is in Frame
            GameBarrier lastBarrier = gameBarrierList.get(gameBarrierList.size() - 1);
            if (lastBarrier.isBarriersCanInFrame())
            {
                randomBarriersHeight();

                insertBarrierInPool(600, 0, turnDownRandomHeight, 0);
                insertBarrierInPool(600, 400 - turnUpRandomHeight, turnUpRandomHeight, 2);
            }
        }
    }

    /*
        Get barrier object in barriersPool;
        Parameter package -> GameBarrier -> save in barrierList
    */
    public void insertBarrierInPool(int barrierLocation_X, int barrierLocation_Y, int barrierHeight, int barrierType)
    {
        GameBarrier gameBarrierTurnDown = GameBarrierPool.getInBarriersPool();
        gameBarrierTurnDown.setBarrierLocation_X(barrierLocation_X);
        gameBarrierTurnDown.setBarrierLocation_Y(barrierLocation_Y);
        gameBarrierTurnDown.setBarrierHeight(barrierHeight);
        gameBarrierTurnDown.setBarrierType(barrierType);
        gameBarrierTurnDown.setBarrierVisible(true);
        gameBarrierList.add(gameBarrierTurnDown);
    }

    // Random Generate barriers Height Range: (100 - 200)
    public void randomBarriersHeight()
    {
        turnDownRandomHeight = barriersRandom.nextInt(400) + 100;
        turnUpRandomHeight = barriersRandom.nextInt(400) + 100;

        // if Barrier TurnUp and TurnDown Overlap --> Re Generate barriers
        if ((turnUpRandomHeight + turnDownRandomHeight) > 400)
        {
            randomBarriersHeight();
        }
    }

    // Judge collision
    public void isCollisionBird(GameBird gameBird)
    {
        for (int i = 0; i < gameBarrierList.size(); ++i)
        {
            GameBarrier gameBarrier = gameBarrierList.get(i);

            // judge collision Box is Overlap
            if (gameBarrier.getBarrierRectCollision().intersects(gameBird.getBirdRectCollision()))
            {
                System.out.println("Bird Collision Barrier");
                gameBird.isBirdLife = false;
            }
        }
    }

    // GameOver to clear gameBarrierList
    public void clearBarriersPool()
    {
        gameBarrierList.clear();
    }

    // Get Info from GameInfo Page
    public int getTextInfo()
    {
        BufferedReader fileReader = null;
        try
        {
            fileReader = new BufferedReader(new FileReader(gameFile));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        int scoreInfo = 0;
        try
        {
            assert fileReader != null;
            scoreInfo = Integer.parseInt(fileReader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fileReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return scoreInfo;
    }

    // Set Info To GameInfo Page
    public void setTextInfo(String info)
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter(gameFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            assert fileWriter != null;
            fileWriter.write(info);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
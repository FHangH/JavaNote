package FlappyBird.gameMainContent;

/*
    Game Timer Setting
*/
public class GameTimer
{
    // Time start
    private long startTime;

    // Time end
    private long endTime;

    // Time difference
    private long timeDiff;

    // init Timer
    public GameTimer() {}

    // Set Timer begin
    public void startTime()
    {
        startTime = System.currentTimeMillis();
    }

    // Get Timer difference
    public long difference()
    {
        endTime = System.currentTimeMillis();
        timeDiff = (endTime - startTime) / 1000;
        return timeDiff;
    }
}
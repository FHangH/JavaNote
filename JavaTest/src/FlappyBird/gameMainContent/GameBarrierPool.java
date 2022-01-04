package FlappyBird.gameMainContent;

import java.util.ArrayList;
import java.util.List;

/*
    Create Object Pool To Manager Generated Barriers
    GameBarrierPool Setting
*/
public class GameBarrierPool
{
    // Save All Barriers Pool
    private static List<GameBarrier> barriersPool = new ArrayList<>();

    // Set barriersPool init object nums
    private static final int BARRIER_POOL_INIT_NUMS = 10;

    // Set barriersPool Max object nums
    private static final int BARRIER_POOL_MAX_NUMS = 20;

    // Static Init barriersPool Object
    static
    {
        for (int i = 0; i < BARRIER_POOL_INIT_NUMS; ++i)
        {
            barriersPool.add(new GameBarrier());
        }
    }

    // Get barrier object in barriersPool
    public static GameBarrier getInBarriersPool()
    {
        int poolSize = barriersPool.size();

        // IF barriersPool haved object -> remove()
        // ELES -> return new GameBarrier()
        if (poolSize > 0)
        {
            System.out.println("Remove a barrier");
            return barriersPool.remove(barriersPool.size() - 1);
        }
        else
        {
            System.out.println("Add a barrier");
            return new GameBarrier();
        }
    }

    // Return barrier object to barriersPool
    public static void returnToBarriersPool(GameBarrier returnGameBarrier)
    {
        if (barriersPool.size() < BARRIER_POOL_MAX_NUMS)
        {
            barriersPool.add(returnGameBarrier);
            System.out.println("Return barrier to Pool");
        }
    }
}
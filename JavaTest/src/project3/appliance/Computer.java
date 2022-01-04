package project3.appliance;

import project3.function.charge;
import project3.function.playGame;

public class Computer extends ApplianceBase implements charge, playGame
{
    public Computer(String name)
    {
        super(name);
    }

    @Override
    public void runStart()
    {
        super.runStart();
    }

    @Override
    public void runOver()
    {
        super.runOver();
    }

    @Override
    public void getCurState()
    {
        super.getCurState();
    }

    @Override
    public void startCharge()
    {
        System.out.println("Computer Is Start Charge");
    }

    @Override
    public void overCharge()
    {
        System.out.println("Computer Is Over Charge");
    }

    @Override
    public void playGames()
    {
        System.out.println("Computer Play Games");
    }

    @Override
    public void overGames()
    {
        System.out.println("Computer Over Games");
    }
}
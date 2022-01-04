package project3.appliance;

import project3.function.charge;

public class WashMachine extends ApplianceBase implements charge
{
    public WashMachine(String name)
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
        System.out.println("WashMachine Is Start Charge");
    }

    @Override
    public void overCharge()
    {
        System.out.println("WashMachine Is Over Charge");
    }
}
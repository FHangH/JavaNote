package project3.appliance;

import project3.function.call;
import project3.function.charge;

public class TelePhone extends ApplianceBase implements charge, call
{
    public TelePhone(String name)
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
        System.out.println("TelePhone Is Start Charge");
    }

    @Override
    public void overCharge()
    {
        System.out.println("TelePhone Is Over Charge");
    }

    @Override
    public void startCall()
    {
        System.out.println("TelePhone Start Call");
    }

    @Override
    public void overCall()
    {
        System.out.println("TelePhone Over Call");
    }
}
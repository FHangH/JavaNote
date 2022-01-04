package project3.appliance;

public class ApplianceBase
{
    private boolean isRunning;

    ApplianceBase(String name)
    {
        isRunning = false;
        System.out.println("<-- " + name + " -->");
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    public void runStart()
    {
        isRunning = true;
        System.out.println("Is Run Start");
        getCurState();
    }
    public void runOver()
    {
        isRunning = false;
        System.out.println("Is Run Over");
        getCurState();
        System.out.println();
    }

    public void getCurState()
    {
        String state = isRunning ? "Running" : "Over";
        System.out.println("CurState>> " + state);
    }
}
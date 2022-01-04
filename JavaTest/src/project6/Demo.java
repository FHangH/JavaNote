package project6;

public class Demo
{
    public static void main(String[] args)
    {
        FH_Thread fh_thread_1 = new FH_Thread();
        FH_Thread fh_thread_2 = new FH_Thread();

        Thread thread_1 = new Thread(fh_thread_1, "<方皓> 跑>>");
        Thread thread_2 = new Thread(fh_thread_2, "<张三> 跑>>");

        thread_1.start();
        thread_2.start();
    }
}

class FH_Thread implements Runnable
{
    int all = 100;

    public void run()
    {
        while (true)
        {
            if (all > 0)
            {
                try
                {
                    Thread.sleep((int)(100+Math.random()*500));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 5m");
                all -= 5;
            }
            else
            {
                System.out.println(Thread.currentThread().getName() + " 完100m");
                break;
            }
        }
    }
}
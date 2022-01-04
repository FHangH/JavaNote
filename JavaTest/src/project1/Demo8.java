package project1;

class Swap
{
    public void swap(int x, int y, int z)
    {
        for (x = 1; x <= 20; ++x)
        {
            for (y = 1; y <= 33; ++y)
            {
                z = 100 - x - y;
                if (x * 5 + y * 3 + z / 3.0 == 100.0)
                {
                    System.out.println("X= " + x + " Y= " + y + " Z= " + z);
                }
            }
        }
    }
}

public class Demo8
{
    public static void main(String[] args)
    {
        Swap swap = new Swap();
        swap.swap(1, 2, 3);
    }
}
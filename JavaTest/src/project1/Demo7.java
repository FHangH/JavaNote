package project1;

class FhMath
{
    int B, S, G;

    public void CalShuiXianHua()
    {
        for (int i = 100; i <= 900; ++i)
        {
            B = i / 100;
            S = (i / 10) % 10;
            G = i % 10;
            if (Math.pow(B, 3) + Math.pow(S, 3) + Math.pow(G, 3) == i)
            {
                System.out.println("水仙花数: " + i);
            }
        }
    }
}

public class Demo7
{
    public static void main(String[] args)
    {
        FhMath fhMath = new FhMath();
        fhMath.CalShuiXianHua();
    }
}
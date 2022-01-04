package project1;

class MathJie
{
    public int fact(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * fact(n - 1);
        }
    }

    public int sum(int n)
    {
        if (n == 1)
        {
            return fact(n);
        }
        else
        {
            return fact(n) + fact(n - 1);
        }
    }
}

public class Demo9
{
    public static void main(String[] args)
    {
        MathJie mathJie = new MathJie();
        int S;
        S = mathJie.sum(5);
        System.out.println(S);
    }
}
package project1;

public class Demo
{
    public static void main(String[] args)
    {
        int appleNum = 10;
        int day;
        for (day = 1; day <= 3; ++day)
        {
            appleNum -= 2;
        }
        System.out.println("Day " + (day - 1) + " , " + "Apple Count : " + appleNum);
    }
}

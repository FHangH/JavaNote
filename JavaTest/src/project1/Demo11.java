package project1;

class Calculator
{
    void getMax(int...nums)
    {
        int maxNum = nums[0];

        for (int num : nums)
        {
            maxNum = Math.max(maxNum, num);
        }
        System.out.println("Max Num: " + maxNum);
    }
}

public class Demo11
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        calculator.getMax(1, 2);
        calculator.getMax(1, 2, 3);
        calculator.getMax(1, 2, 3, 4);
    }
}
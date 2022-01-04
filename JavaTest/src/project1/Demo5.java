package project1;

import java.util.Scanner;
import java.util.Random;

class CalculatorSystem
{
    private int questionCount;
    private int scoreCount;

    private enum CalculateOperation
    {
        ADD, SUB, /*MULTI, DIVIDE*/
    }

    Scanner scanner = new Scanner(System.in);
    Random random = new Random(System.currentTimeMillis());

    CalculatorSystem()
    {
        this.scoreCount = 0;
    }

    public void CalStart()
    {
        System.out.println("<<-- 输入题数(最少1题--最多10题) -->>");
        System.out.print("输入>>");
        questionCount = scanner.nextInt();

        if (questionCount < 1 || questionCount > 10)
        {
            questionCount = questionCount < 1 ? 1 : 10;
        }

        CalRandomQuestion();
    }

    public void CalRandomQuestion()
    {
        int tempA, tempB, inputC, a, b, c;
        CalculateOperation calOperation;

        for (int i = 1; i <= questionCount; ++i)
        {
            System.out.print("第" + i + "题: ");
            int curRand = random.nextInt(2);

            calOperation = CalculateOperation.class.getEnumConstants()[curRand];
            tempA = random.nextInt(101);
            tempB = random.nextInt(101);
            a = Math.max(tempA, tempB);
            b = Math.min(tempB, tempA);

            switch (calOperation)
            {
                case ADD ->
                        {
                            c = a + b;
                            System.out.print(a + "+" + b + "=");
                            inputC = scanner.nextInt();
                            CalCheckAnswer(c, inputC);
                        }
                case SUB ->
                        {
                            c = a - b;
                            System.out.print(a + "-" + b + "=");
                            inputC = scanner.nextInt();
                            CalCheckAnswer(c, inputC);
                        }
            }
        }

        CalSumScore();
    }

    public void CalCheckAnswer(int c, int inputC)
    {
        String printLog = (c == inputC) ? "正确" : "错误";
        boolean isRight = (c == inputC);

        if (isRight)
        {
            this.scoreCount++;
        }
        System.out.println(printLog);
    }

    public void CalSumScore()
    {
        System.out.println("答对" + scoreCount + "题");
        scoreCount = 0;
        System.out.println();
    }

    public void CalEnd()
    {
        System.out.println("<<-- 已退出答题系统 -->>");
    }
}

public class Demo5
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        CalculatorSystem calSys = new CalculatorSystem();

        while (true)
        {
            System.out.println("<<-- (Y/y_开始)--(N/n_结束) -->>");
            System.out.print("输入>>");
            String inputChar = scanner.next();

            if (inputChar.equalsIgnoreCase("Y"))
            {
                calSys.CalStart();
            }
            else if (inputChar.equalsIgnoreCase("N"))
            {
                calSys.CalEnd();
                System.exit(1);
            }
            else
            {
                System.out.println("输入正确的选项");
            }
        }
    }
}
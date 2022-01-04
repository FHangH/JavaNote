package project5;

import java.util.Random;
import java.util.Scanner;

class MyException extends Exception
{
    MyException(String s)
    {
        super(s);
    }
}

class VerifyDemo
{
    int[] verifyArr = new int[6];

    void printArr(int[] arr)
    {
        for (int j : arr)
        {
            System.out.print(Character.toString(j) + " ");
        }
    }

    void createVerifyCode()
    {
        int verifySeed = 65;
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < 6; ++i)
        {
            int rand = random.nextInt(26);
            verifyArr[i] = verifySeed + rand;
        }

        printArr(verifyArr);
    }

    int[] transformStringToArrInt(String s)
    {
        int[] arr = new int[6];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; ++i)
        {
            arr[i] = charArr[i];
        }
        return arr;
    }

    boolean checkVerifyCode(int[] arr)
    {
        boolean isTrue = true;
        for (int i = 0; i < arr.length; ++i)
        {
            if (arr[i] != verifyArr[i])
            {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }
}

public class Demo
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        VerifyDemo verifydemo = new VerifyDemo();
        String inputStr;

        System.out.print("Verify Code: ");
        verifydemo.createVerifyCode();
        System.out.println();
        System.out.print(">> ");
        inputStr = scanner.next();

        int[] verifyArr = verifydemo.transformStringToArrInt(inputStr);
        boolean isVerifyTrue = verifydemo.checkVerifyCode(verifyArr);

        try
        {
            if (isVerifyTrue)
            {
                throw new MyException("<-- Verification Code True! -->");
            }
            else
            {
                throw new MyException("<-- Verification Code Error! -->");
            }
        }
        catch (MyException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
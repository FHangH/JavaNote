package project1;

import java.util.Scanner;

public class Demo2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入三位数：");
        int EnterNum = scanner.nextInt();

        int GW, SW, BW;

        GW = (EnterNum % 10);
        SW = (EnterNum % 100) / 10;
        BW = (EnterNum / 100);

        System.out.println("个位：" + GW + " 十位：" + SW + " 百位：" + BW);
    }
}
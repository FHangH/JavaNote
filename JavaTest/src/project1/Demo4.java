package project1;

import java.util.Scanner;

class Prophet
{
    int year;
    boolean isLeapYear;

    public void CalLeapYear(int year)
    {
        this.year = year;
        isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        String leapYear = isLeapYear ? "是闰年" : "不是闰年";
        System.out.println(year + leapYear);
    }

    public void CalDaysEveryMonth()
    {
        System.out.println(this.year + "的每月天数：");
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i = 0; i < days.length; ++i)
        {
            if (this.isLeapYear && i == 1)
            {
                System.out.println("第" + (i + 1) + "月: " + (days[i] + 1));
            }
            else
            {
                System.out.println("第" + (i + 1) + "月: " + days[i]);
            }
        }
    }
}

public class Demo4
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Prophet pro = new Prophet();

        while (true)
        {
            System.out.print("输入年份<0_退出>：");
            int num = scanner.nextInt();
            if (num == 0)
            {
                System.exit(0);
            }
            else
            {
                pro.CalLeapYear(num);
                pro.CalDaysEveryMonth();
            }
        }
    }
}
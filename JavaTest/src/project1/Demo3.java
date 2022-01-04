package project1;

import java.util.Scanner;

class MySelf
{
   private final String stu_ID;
   private final String stu_Name;
   private final String stu_Hobby;
   private final int stu_Date;

   MySelf()
   {
       stu_ID = "82104322666";
       stu_Name = "FHang";
       stu_Hobby = "发呆";
       stu_Date = 1998;
   }

    public String getStu_ID() {
        return stu_ID;
    }

    public String getStu_Name() {
        return stu_Name;
    }

    public String getStu_Hobby() {
        return stu_Hobby;
    }

    public int getStu_Date() {
        return stu_Date;
    }

    public String getIsLeapYear()
    {
        return (stu_Date % 4 == 0 && stu_Date % 100 != 0) || (stu_Date % 400 == 0) ? "是" : "不是";
    }
}

public class Demo3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MySelf mySelf = new MySelf();

        while (true)
        {
            System.out.println("1_学号,2_姓名,3_爱好,4_出生日期,<其它_退出>");
            System.out.print("选择: ");
            int num = scanner.nextInt();

            switch (num) {
                case 1 -> System.out.println("学号: " + mySelf.getStu_ID());
                case 2 -> System.out.println("姓名: " + mySelf.getStu_Name());
                case 3 -> System.out.println("爱好: " + mySelf.getStu_Hobby());
                case 4 -> System.out.println("出生日期: " + mySelf.getStu_Date() + " - 闰年: " + mySelf.getIsLeapYear());
                default -> System.exit(0);
            }
        }
    }
}
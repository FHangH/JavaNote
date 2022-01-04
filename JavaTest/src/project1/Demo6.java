package project1;

import java.util.Scanner;

class PersonInfo
{
    private String fh_ID;
    private String fh_Name;
    private String fh_Hobby;
    private int fh_Date;

    Scanner scanner = new Scanner(System.in);

    public String getFh_ID() {
        return fh_ID;
    }
    public void setFh_ID(String fh_ID) {
        this.fh_ID = fh_ID;
    }

    public String getFh_Name() {
        return fh_Name;
    }
    public void setFh_Name(String fh_Name) {
        this.fh_Name = fh_Name;
    }

    public String getFh_Hobby() {
        return fh_Hobby;
    }
    public void setFh_Hobby(String fh_Hobby) {
        this.fh_Hobby = fh_Hobby;
    }

    public int getFh_Date() {
        return fh_Date;
    }
    public void setFh_Date(int fh_Date) {
        this.fh_Date = fh_Date;
    }

    public void StartPersonInfo()
    {
        while (true)
        {
            System.out.println("<-- 1_输入信息,2_显示信息,3_退出 -->");
            System.out.print("选择>>");
            int num = scanner.nextInt();
            switch (num)
            {
                case 1 -> InputPersonInfo();
                case 2 -> ShowPersonInfoMenu();
                case 3 -> ExitPersonInfo();
            }
        }
    }

    public void ShowPersonInfoMenu()
    {
        System.out.println("<-- 1_学号,2_姓名,3_爱好,4_年份,5_返回上一级 -->");

        while (true)
        {
            System.out.print("选择>>");
            int num = scanner.nextInt();

            switch (num)
            {
                case 1 -> System.out.println("ID: " + getFh_ID());
                case 2 -> System.out.println("姓名: " + getFh_Name());
                case 3 -> System.out.println("爱好: " + getFh_Hobby());
                case 4 -> System.out.println("生日: " + getFh_Date());
                case 5 -> StartPersonInfo();
            }
        }
    }

    public void InputPersonInfo()
    {
        System.out.print("输入ID>>");
        setFh_ID(scanner.next());

        System.out.print("输入姓名>>");
        setFh_Name(scanner.next());

        System.out.print("输入爱好>>");
        setFh_Hobby(scanner.next());

        System.out.print("输入生日>>");
        setFh_Date(scanner.nextInt());
    }

    public void ExitPersonInfo()
    {
        System.out.println("<-- 已退出 -->");
        System.exit(1);
    }
}

public class Demo6
{
    public static void main(String[] args)
    {
        new Scanner(System.in);
        PersonInfo personInfo = new PersonInfo();

        personInfo.StartPersonInfo();
    }
}
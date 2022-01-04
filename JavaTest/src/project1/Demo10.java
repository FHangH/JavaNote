package project1;

import java.util.Scanner;

class Pet
{
    private String name;
    private String type;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    Scanner scanner = new Scanner(System.in);

    Pet()
    {
        TipInfo();

        System.out.print("输入名称>>");
        setName(scanner.next());

        System.out.print("输入类别>>");
        setType(scanner.next());

        PrintPetInfo();
    }

    void TipInfo()
    {
        System.out.println("<-- 输入宠物相关信息 -->");
    }

    void PrintPetInfo()
    {
        System.out.println("<-- 打印宠物相关信息 -->");
        System.out.println("宠物名称: " + getName());
        System.out.println("宠物类别: " + getType());
    }
}

public class Demo10
{
    public static void main(String[] args)
    {
        new Pet();
    }
}
package project8;

import java.util.Comparator;
import java.util.Vector;

class Student
{
    int id;
    String name;
    String sex;
    int computerGrade;
    int cGrade;
    int mathGrade;
    int physicalGrade;

    Student(int id, String name, String sex, int computerGrade, int cGrade, int mathGrade, int physicalGrade)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.computerGrade = computerGrade;
        this.cGrade = cGrade;
        this.mathGrade = mathGrade;
        this.physicalGrade = physicalGrade;
    }
}

class DownSort implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {
        int g1 = s1.computerGrade + s1.cGrade + s1.mathGrade + s1.physicalGrade;
        int g2 = s2.computerGrade + s2.cGrade + s2.mathGrade + s2.physicalGrade;

        return Integer.compare(g2, g1);
    }
}

public class Demo
{
    public static void main(String[] args)
    {
        Vector<Student> vS = new Vector<>();
        Comparator<Student> comparator = new DownSort();
        Student s1 = new Student(1001, "mary", "女", 90, 80, 78, 83);
        Student s2 = new Student(1002, "tom", "男", 80, 81, 79, 84);
        Student s3 = new Student(1003, "jerry", "男", 93, 82, 80, 85);
        Student s4 = new Student(1004, "john", "男", 90, 83, 81, 86);

        vS.add(s1);
        vS.add(s2);
        vS.add(s3);
        vS.add(s4);

        System.out.println("全部显示》》");
        printInfo(vS);

        vS.sort(comparator);

        System.out.println("按总分排序》》");
        printInfo(vS);

        System.out.println("查询》》");
        searcher(vS, 1001);
    }

    static void printInfo(Vector<Student> vS)
    {
        for (Student s : vS)
        {
            System.out.println(s.id + " " + s.name + " " + s.sex + " " + s.computerGrade + " " + s.cGrade + " " + s.mathGrade + " " + s.physicalGrade);
        }
        System.out.println();
    }

    static void searcher(Vector<Student> vs, int id)
    {
        for (Student s : vs)
        {
            if (s.id == id)
            {
                System.out.println(s.id + " " + s.name + " " + s.sex + " " + s.computerGrade + " " + s.cGrade + " " + s.mathGrade + " " + s.physicalGrade);
            }
        }
        System.out.println();
    }
}

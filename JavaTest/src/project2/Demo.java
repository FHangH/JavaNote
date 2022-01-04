package project2;

public class Demo
{
    public static void main(String[] args)
    {
        Human student = new Student();
        Human teacher = new Teacher();

        Getter getter = new Getter();

        getter.getInfo((Student) student);
        System.out.println();
        getter.getInfo((Teacher) teacher);
    }
}
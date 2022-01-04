package project2;

public class Getter
{
    void getInfo(Student student)
    {
        System.out.println("Name: " + student.getName() + "\nStuID: " + student.getStuID() + "\nRoomID: " + student.getRoomID());
    }

    void getInfo(Teacher teacher)
    {
        System.out.println("Name: " + teacher.getName() + "\nJob: " + teacher.getJob() + "\nSalary: " + teacher.getSalary());
    }
}
package project2;

public class Teacher extends Human
{
    private String name;
    private String job;
    private int salary;

    Teacher()
    {
        name = "WW";
        job = "MathTeacher";
        salary = 1000;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getJob()
    {
        return job;
    }
    public void setJob(String job)
    {
        this.job = job;
    }

    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}
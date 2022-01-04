package project2;

public class Student extends Human
{
    private String name;
    private int stuID;
    private int roomID;

    Student()
    {
        name = "QQ";
        stuID = 1;
        roomID = 304;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getStuID()
    {
        return stuID;
    }
    public void setStuID(int stuID)
    {
        this.stuID = stuID;
    }

    public int getRoomID()
    {
        return roomID;
    }
    public void setRoomID(int roomID)
    {
        this.roomID = roomID;
    }
}
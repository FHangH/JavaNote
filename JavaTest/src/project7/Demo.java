package project7;

public class Demo
{
    public static void main(String[] args)
    {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.initPage();
        leaderBoard.writePage();
        leaderBoard.readPage();
        leaderBoard.updatePage();
        leaderBoard.readPage();
    }
}
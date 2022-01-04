package project7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LeaderBoard
{
    Scanner scanner =new Scanner(System.in);
    Vector<Player> vPlayer = new Vector<>();
    Comparator<Player> comparator = new UpSort();

    public void initPage()
    {
        System.out.println("<-- Origin Leader Board -->");
        Player player1 = new Player("A", 1);
        Player player2 = new Player("B", 4);
        Player player3 = new Player("C", 5);
        Player player4 = new Player("D", 8);

        vPlayer.add(player1);
        vPlayer.add(player2);
        vPlayer.add(player3);
        vPlayer.add(player4);

        vPlayer.sort(comparator);
    }

    public void readPage()
    {
        FileReader fileReader = null;
        try
        {
            fileReader = new FileReader("src\\project7\\leaderBoard.txt");
            int i;
            while ((i = fileReader.read()) != -1)
            {
                System.out.print((char)i);
            }
        }
        catch (Exception e)
        {
            System.out.println("Page Can't Read");
        }
        finally
        {
            try
            {
                assert fileReader != null;
                fileReader.close();
            }
            catch (IOException e)
            {
                System.out.println("Page Not Found");
            }
        }
    }

    public void writePage()
    {
        FileWriter fileWriter = null;
        try
        {
            fileWriter = new FileWriter("src\\project7\\leaderBoard.txt");
            for (Player player : vPlayer)
            {
                fileWriter.write(player.grade + ": " + player.name + "\r\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Page Can't Write");
        }
        finally
        {
            try
            {
                assert fileWriter != null;
                fileWriter.close();
            }
            catch (IOException e)
            {
                System.out.println("Page Not Found");
            }
        }
    }

    public void updatePage()
    {
        System.out.println("Add New Player >>");

        System.out.print("Input Name: ");
        String newName = scanner.next();

        System.out.print("Input Grade: ");
        int newGrade = scanner.nextInt();

        Player newPlayer = new Player(newName, newGrade);
        vPlayer.add(newPlayer);
        vPlayer.sort(comparator);

        System.out.println();
        System.out.println("### Updated Leader Board ###");
        System.out.println();
        System.out.println("<-- New Leader Board -->");

        writePage();
    }
}
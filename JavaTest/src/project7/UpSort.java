package project7;

import java.util.Comparator;

public class UpSort implements Comparator<Player>
{
    public int compare(Player player1, Player player2)
    {
        return Integer.compare(player1.grade, player2.grade);
    }
}
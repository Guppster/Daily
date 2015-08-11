package me.GurpreetSingh;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Board board = new Board(7, 8);

        for(;;)
        {
            String input = in.nextLine();

            if(board.placePlayerInColumn((int)input.split(" ")[0].toUpperCase().toCharArray()[0]-65, Player.X ))
            {
                System.out.println("Player X Wins");
                break;
            }

            if(board.placePlayerInColumn((int)input.split(" ")[1].toUpperCase().toCharArray()[0]-65, Player.O ))
            {
                System.out.println("Player O Wins");
                break;
            }
        }

    }//End of the main method
}//End of the main class

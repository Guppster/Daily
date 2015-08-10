package me.GurpreetSingh;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean turnX = true;

        System.out.println("Enter the width and height of the board");
        Board board = new Board(in.nextInt(), in.nextInt());

        System.out.println("\n Enter The Moves: ");

        for(;;)
        {
            turnX ^= true;
            board.placePlayerInColumn((int)in.nextLine().split(" ")[0].toUpperCase().toCharArray()[0]-65, (turnX) ? Player.X : Player.O);
        }



    }//End of the main method
}//End of the main class

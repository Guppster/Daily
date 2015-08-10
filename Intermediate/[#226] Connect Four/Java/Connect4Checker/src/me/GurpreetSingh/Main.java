package me.GurpreetSingh;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the width and height of the board");
        Board board = new Board(in.nextInt(), in.nextInt());

        System.out.println("\n Enter The Moves: ");
        
    }//End of the main method
}//End of the main class

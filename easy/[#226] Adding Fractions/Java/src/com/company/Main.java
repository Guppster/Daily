package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main
{
    static Scanner in = new Scanner(System.in);
    static Stack<Integer> n = new Stack<>();
    static Stack<Integer> d = new Stack<>();

    public static void main(String[] args)
    {
        System.out.println("How many fractions?");
        int quantity = in.nextInt();

        for (int i = 0; i < quantity+1; i++) parseFraction();

        addStacks();

        int finalN = n.pop();
        int finalD = d.pop();
        int finalGCM = findGCM(finalN, finalD);
        System.out.println("The Answer is: " + finalN/finalGCM + "/" + finalD/finalGCM);
    }//End of main method

    private static void addStacks()
    {
        if(n.size() == 1) return;

        int d1 = d.pop();
        int d2 = d.pop();
        int n1 = n.pop();
        int n2 = n.pop();

        int gcd = findGCM(d1, d2);

        n1 = (d2 / gcd) * n1;
        n2 = (d1 / gcd) * n2;

        d.push((d1 * d2) / gcd);
        n.push(n1 + n2);

        addStacks();
    }//End of addStacks method

    public static void parseFraction()
    {
        String temp = in.nextLine();
        if(!temp.equals(""))
        {
            n.push(Integer.parseInt(temp.split("/")[0]));
            d.push(Integer.parseInt(temp.split("/")[1]));
        }

    }//End of parseFraction Method

    public static int findGCM(int x, int y)
    {
        return y == 0 ? x : findGCM(y, x % y);
    }//End of findGCD method
}//End of main class

package com.company;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        for(String input: args)
        {
            int [] mass = getMass(input);
            int balanceIndex = getBalanceIndex(mass);
            if(balanceIndex == 0)
            {
                System.out.println(input + " DOES NOT BALANCE");
                continue;
            }

            System.out.println(input.substring(0, balanceIndex) + " " + input.charAt(balanceIndex) + " " +  input.substring(balanceIndex+1, mass.length) + " " + getBalancedSum(Arrays.copyOfRange(mass, balanceIndex, mass.length)));
            System.out.println(Arrays.toString(Arrays.copyOfRange(mass, 0, balanceIndex)) + " " + mass[balanceIndex] + " " + Arrays.toString(Arrays.copyOfRange(mass, balanceIndex, mass.length)) + " " + getBalancedSum(Arrays.copyOfRange(mass, balanceIndex, mass.length)) + "\n");

        }
    }//End of main method

    //Returns the index at which the mass balances.
    private static int getBalanceIndex(int[] mass)
    {
        double epsilon = 1e-9;
        double total = 0;

        for(int n : mass) total += n;
        double mean = getBalancedSum(mass) / total;
        int m  = (int)Math.round(mean);
        if(Math.abs(mean - m) < epsilon) return m;
        return 0;
    }//End of getBalanceIndex

    //Returns the sum of the values scaled by their index
    private static int getBalancedSum(int[] mass)
    {
        int total = 0;
        for (int i = 0; i < mass.length; i++) total += mass[i]*i;
        return total;
    }//End of getBalancedSum

    //Retrieves the mass of every letter in the word
    private static int[] getMass(String input)
    {
        char [] inputChars = input.toCharArray();
        int [] inputMass = new int[inputChars.length];

        for (int i = 0; i < inputChars.length; i++)
        {
            int temp = (int)inputChars[i];
            inputMass[i] = (temp<=90 & temp>=65) ? temp-64 : -1;
        }

        return inputMass;
    }//End of getMass method
}//End of main class

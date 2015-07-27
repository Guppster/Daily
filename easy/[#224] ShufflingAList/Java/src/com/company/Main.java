package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args));
        String[] results = new String[args.length];

        int n = rand.nextInt((args.length - 1) + 1) + 1;

        for(int i = 0; i < results.length; i++)
        {
            results[i] = arguments.remove(n);
            n = rand.nextInt((args.length - 1) + 1) + 1;
        }

        for (int i = 0; i < results.length; i++)
        {
            System.out.println(results[i]);
        }
    }
}

package me.GurpreetSingh;

public class Main {

    public static void main(String[] args)
    {
        int value = 100;
        System.out.println(fizzbuzz(value));
    }//End of main method

    private static String fizzbuzz(int currentIteration)
    {
        String result;
        if(currentIteration == 0)
        {
            return "";
        }
        else
        {
            final int mod3 = currentIteration % 3;
            final int mod5 = currentIteration % 5;
            if(mod3 == 0 && mod5 == 0) result = "FizzBuzz";
            else if(mod3 == 0) result = "Fizz";
            else if(mod5 == 0) result = "Buzz";
            else result = String.valueOf(currentIteration);

            return result + "\n" + fizzbuzz(--currentIteration);
        }
    }//End of fizzbuzz method
}//End of class

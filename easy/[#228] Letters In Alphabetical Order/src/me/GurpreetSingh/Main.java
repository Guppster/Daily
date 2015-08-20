package me.GurpreetSingh;

public class Main
{
    public static void main(String[] args)
    {
        for (int i = 0; i < args.length; i++)
        {
            if(!inOrder(args[i]))
            {
                otherOrder(args[i]);
            }
        }
    }//End of main method

    private static boolean inOrder(String arg)
    {
        for (int i = 1; i < arg.length(); i++)
        {
            if(!(arg.charAt(i) >= arg.charAt(i-1)))
            {
                return false;
            }
        }

        System.out.println(arg + ": IN ORDER");
        return true;
    }

    private static void otherOrder(String arg)
    {
        for (int i = 1; i < arg.length(); i++)
        {
            if(!(arg.charAt(i) < arg.charAt(i-1)))
            {
                System.out.println(arg + ": NOT IN ORDER");
                return;
            }
        }

        System.out.println(arg + ": REVERSE ORDER");
    }

}//End of main class

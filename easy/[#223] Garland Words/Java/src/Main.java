import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String word = in.nextLine();
        int garland = garland(word);
        System.out.println("This word has a degree of " + garland + "\n");

        System.out.println("Enter the number of iterations you wish to see: ");
        garlandMultiPrint(in.nextInt(), garland, word);

        mostGarlardWord("\\enable1.txt");

    }//End of main method

    private static int garland(String word)
    {
        for (int i = word.length() - 1; i >= 0; i--)
        {
            if (word.substring(0, i).equalsIgnoreCase(word.substring(word.length() - i, word.length())))
            {
                return i;
            }
        }
        return 0;
    }//End of garland


    private static void garlandMultiPrint(int iter, int garland, String word)
    {
        String garlandWord = word.substring(0, word.length()-garland);
        for(int j = iter; j > 0 ; j--)
        {
            System.out.print(garlandWord);
        }
        System.out.println(word.substring(word.length()-garland, word.length()) + "\n");
    }//End of garlandMultiPrint

    private static void mostGarlardWord(String filename)
    {
        String maxWord = "";
        int maxGarland = 0;
        int temp;

        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            String line = "quack";

            while (line != null)
            {
                line = br.readLine();

                if(line != null)
                {
                    temp = garland(line);

                    if (temp > maxGarland)
                    {
                        maxGarland = temp;
                        maxWord = line;
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println("Woahhhhhh, it's getting hot in here!!");
        }

        System.out.println("The word with the highest garland degree in " + filename + " is " + maxWord + " with a degree of " + maxGarland);
    }//End of mostGarlardWord method
}//End of main class


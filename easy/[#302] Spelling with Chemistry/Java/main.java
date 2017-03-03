import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        //Scanner to read input
        Scanner scaner = new Scanner();

        //List to store elements read in from file
        List<Element> elements = new ArrayList<Element>();

        //Read in the CSV
        try{
            File input = new File("../input.csv");
            InputStream inputStream = new FileInputStream(input);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            elements = br
                .lines()
                .skip(1)
                .map(mapToElement)
                .collect(Collectors.toList());

            br.close();
        } catch (FileNotFoundException | IOException e){}

        Stream.generate(() ->
        {
            System.out.print("Enter a word: ");
            scanner.next();
        });
    }

        //Function to generate an object from a line
        private Function<String, Element> mapToElement = (line) ->
        {
            line = line.replaceAll("\"", "");
            String[] data = line.split(",");

            return new Element(data[1].trim(), data[2].trim(), data[3].trim());
        }

        private class Element
        {
            private String symbol;
            private String name;
            private int weight;

            public Element(String symbol, String name, int weight)
            {
                this.symbol = symbol;
                this.name = name;
                this.weight = weight;
            }

            public String getSymbol()
            {
                return symbol;
            }

            public String getName()
            {
                return name;
            }

            public int getWeight()
            {
                return weight;
            }
        }
}

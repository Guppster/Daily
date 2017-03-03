public class main
{
    public static void main(String[] args)
    {
        List<Element> elements = new ArrayList<Element>();

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

        private Function<String, Element> mapToElement = (line) ->
        {
            String[] data = line.split(",");

            return new Element(data[0], data[1], data[2]);
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
}

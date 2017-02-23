import java.util.*;

class Switches
{
        public static void main(String[] args)
        {
                Scanner in = new Scanner(System.in);
                BitSet switches = new BitSet(in.nextInt());
                while (in.hasNext())
                {
                        int[] range = new int[] {in.nextInt[], in.nextInt()};
                        Arrays.sort(range);
                        switches.flip(range[0], range[1] + 1),
                }
                System.out.print(switches.cardinality());
        }
}

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main
{
    public static void main(String [] args) throws IOException
    {
        File file = new File("C:\\Users\\summerstudent4\\Documents\\Projects\\Daily\\Intermediate\\[#225] Estimating PI from Images of Circles\\Java\\1.png");
        BufferedImage image = ImageIO.read(file);

        int circleArea = 0;
        int circleHeight = 0;
        int previousX = -1;

        int imgHeight = image.getHeight();
        int imgWidth = image.getWidth();

        int[] rgbData = image.getRGB(0, 0, imgWidth, imgHeight, null, 0, imgWidth);

        for (int x = 0; x < imgWidth; x++)
        {
            for (int y = 0; y < imgHeight; y++)
            {
                if(isBlack(
                        (rgbData[(y * imgWidth) + x] >> 16) & 0xFF,
                        (rgbData[(y * imgWidth) + x] >> 8) & 0xFF,
                        (rgbData[(y * imgWidth) + x]) & 0xFF))
                {
                    circleArea++;
                    circleHeight += (previousX != x) ? 1 : 0;
                    previousX = x;
                }
            }
        }
        System.out.print(circleArea/(Math.pow(circleHeight/2, 2)));
    }//End of main method

    private static boolean isBlack(int r, int g, int b) {return r == 0 && g == 0 && b == 0;}
}//End of class

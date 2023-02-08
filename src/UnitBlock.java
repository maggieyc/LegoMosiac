import java.awt.Color;
import java.awt.image.BufferedImage;

public class UnitBlock {
    static int block_width;
    Color c;
    int xx, yy;

    public UnitBlock(BufferedImage i, int x, int y, int width, int length, Colors possibleColors) throws Exception {
        // Constructor Method
        xx = x;
        yy = y;
        this.c = getColor(i, xx, yy, width, length, possibleColors);
    }

    static Color getColor(BufferedImage i, int xx, int yy, int width, int length, Colors possibleColors) throws Exception {
        // block_width = number of pixels in the smallest unit lego block
        // xx and yy are the coordinates of the top left corner of the box to average
        // width and length are the dimensionso of the image in pixels

        int l, k, r=0,g=0 ,b=0, pixel_count = 0;

        // ???
        if (xx == width || yy == length){
            Color c = new Color(i.getRGB(xx,yy), true);
            return c;
        }

        // Get the average RGB in the specified region
        for (l=xx; l < xx+block_width  && l <= width; l++){
            for (k=yy; k < yy+block_width && k <= length; k++){
                Color c = new Color(i.getRGB(l,k), true);
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
                pixel_count++;
            }
        }
        r /= pixel_count;
        g /= pixel_count;
        b /= pixel_count;

        Color average = new Color(r,g,b);

        // Return the closest block color available
        return possibleColors.getClosestColor(average);
    }
}

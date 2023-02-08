// TO DO:
// Ideas implement a blur option and a hard edge option.
// need to make it work for different sizes
// Need to make it only a few possible color options

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.*;

public class Lego{

    public static void makeLegos(String file, String file_dest, int max_blocks, Colors possibleColors) throws Exception {
        BufferedImage i = ImageIO.read(new File(file)); // ENTER FILENAME HERE
        int width = i.getWidth();
        int length = i.getHeight();

        UnitBlock.block_width = 4;


        Graphics2D g = i.createGraphics();

        UnitBlock[] blocks = new UnitBlock[max_blocks];
        int l,k, count=0;
        for (l = 0; l<width; l+=UnitBlock.block_width){
            for (k = 0; k<length; k+=UnitBlock.block_width){
                blocks[count] = new UnitBlock(i,l,k,width,length, possibleColors);

                g.setColor(blocks[count].c);

                if (l <= width%UnitBlock.block_width){
                    g.fillRect(l,k, width%UnitBlock.block_width, UnitBlock.block_width);
                } else if (k <= length%UnitBlock.block_width) {
                    g.fillRect(l,k, UnitBlock.block_width, length%UnitBlock.block_width);
                } else{
                    g.fillRect(l,k, UnitBlock.block_width, UnitBlock.block_width);
                }

            }
        }
        g.dispose();

        File f = new File(file_dest);
        ImageIO.write(i, "png", f);
    }

    public static void main(String[] args) throws Exception {
        Colors possibleColors = new Colors(5);
        possibleColors.addColors(new Color[]{Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN,Color.WHITE, Color.ORANGE });
        makeLegos("/Users/maggiechen/IdeaProjects/lego/src/heart.png", "/Users/maggiechen/IdeaProjects/lego/src/heart_new.png", 3, possibleColors);

    }

}

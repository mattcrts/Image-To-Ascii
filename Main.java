package zone.mafu;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(args[0]));
        } catch (IOException e){
            System.out.println("Error reading image or image file path not supplied");
            System.exit(1);
        }

        int pixel;

        for(int i = 0; i < img.getHeight(); i++){
            for(int j = 0; j < img.getWidth(); j++){
                pixel = img.getRGB(j,i);
                int r = (pixel>>16) & 0xff; //thank you random internet tutorial i found for providing me with these three scary looking lines to get the rgb values
                int g = (pixel>>8) & 0xff;
                int b = pixel & 0xff;
                int avgPercent = (int)((((r + g + b)/3.0) / 255) * 100);

                if(avgPercent > 90){ //arbitrary numbers i chose. changing these could lead to more accurate results
                    System.out.print("#");
                } else if (avgPercent > 80){
                    System.out.print("@");
                } else if (avgPercent > 50){
                    System.out.print("+");
                } else if (avgPercent > 35){
                    System.out.print(":");
                } else if(avgPercent > 10){
                    System.out.print(".");
                } else{
                    System.out.print(" ");
                }

            }
            System.out.println();
        }

    }
}

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = getInput("Input the path of the image you would like to convert to ASCII art: ");

        File f = new File(path);
        BufferedImage img = ImageIO.read(f);

        int w, h;
        w = img.getWidth();
        h = img.getHeight();

        StringBuilder sb = new StringBuilder();//store the chars here

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int rgb = img.getRGB(x, y);
                Color c = new Color(rgb);
                int r, g, b;

                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();

                float grayness = toGrayScale(r, g, b);
                String asciiCaret = getAsciiCaret(grayness);
                sb.append(asciiCaret);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String getInput(String msg) {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        return input;
    }

    public static float toGrayScale(int r, int g, int b) {
        float grayRed = r*0.299f;
        float grayGreen = g*0.587f;
        float grayBlue = b*0.114f;
        float grayScale = ((grayRed + grayGreen + grayBlue) / 3);
        return grayScale;
    }

    public static String getAsciiCaret(float grayness) {
        StringBuilder sb = new StringBuilder();
        if (grayness <= 10) {
        } else if (grayness <= 20) {
            sb.append("*");
        } else if (grayness <= 30) {
            sb.append(">");
        } else if (grayness <= 40) {
            sb.append("$");
        } else if (grayness <= 50) {
            sb.append("%");
        } else if (grayness <= 60) {
            sb.append("^");
        } else if (grayness <= 70) {
            sb.append("\"");
        } else if (grayness <= 80) {
            sb.append(")");
        } else if (grayness <= 100) {
            sb.append("(");
        } else if (grayness <= 110){
            sb.append("*");
        } else if (grayness <= 120) {
            sb.append(".");
        } else if (grayness <= 130) {
            sb.append("+");
        } else if (grayness <= 140) {
            sb.append("-");
        } else if (grayness <= 150) {
            sb.append("_");
        } else {
            sb.append("|");
        }
        return sb.toString();
    }
}

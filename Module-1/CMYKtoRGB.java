// Assignment 5 - CMYKtoRGB - converts from CMYK format to RGB format
// test sample: 0.0 1.0 0.0 0.0 Result: red=255, green=0, blue=255
// test sample: 0.0 0.4392156862745098 1.0 0.0 Result: red=255, green=143, blue=0

public class CMYKtoRGB {
    public static void main(String[] args) {

        // Get input arguments in CMYK order
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);

        double cWhite = 1.0 - k;     // this is needed for conversion

        // supply cyan to get red
        int cRED = (int) Math.round(255 * cWhite * (1.0 - c));  // convert color in double format - result is integer
        cRED = Math.max(0, Math.min(255, cRED));                // if the value is more than 255 then trim it to 255.

        // supply magenta to get green
        int cGreen = (int) Math.round(255 * cWhite * (1.0 - m));
        cGreen = Math.max(0, Math.min(255, cGreen));

        // supply yellow to get blue
        int cBlue = (int) Math.round(255 * cWhite * (1.0 - y));
        cBlue = Math.max(0, Math.min(255, cBlue));

        // System.out.println("CMYKtoRGB: Converts colors in CMYK to RGB format");
        // System.out.println("Input CMYK numbers: (" + args[0] + ", " + args[1] + ", " + args[2] + ", " + args[3] + ")");
        // System.out.println("Converted RGB numbers: (" + cRED + ", " + cGreen + ", " + cBlue + ")");
        System.out.println("red   = " + cRED);
        System.out.println("green = " + cGreen);
        System.out.println("blue  = " + cBlue);
        return;
    }
}

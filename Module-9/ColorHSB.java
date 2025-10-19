//Test Cases
// java-introcs ColorHSB 25 84 97 < web.txt :: Red (0, 100, 100)
// java-introcs ColorHSB 350 100 45 < web.txt :: Maroon (0, 100, 50)
// java-introcs ColorHSB 25 84 97 < wiki.txt :: Princeton_Orange (26, 85, 96)
public class ColorHSB {
    private static final int MAX_HUE = 359;
    private static final int MAX_SAT_BRI = 100;
    private final int hue, saturation, brightness;
    // creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > MAX_HUE)
            throw new IllegalArgumentException("Error: Out of Hue Range - 0 to 359");
        if (s < 0 || s > MAX_SAT_BRI)
            throw new IllegalArgumentException("Error: Out of Saturation Range - 0 to 100");
        if (b < 0 || b > MAX_SAT_BRI)
            throw new IllegalArgumentException("Error: Out of Brightness Range - 0 to 100");

        hue = h;
        saturation = s;
        brightness = b;
    }
    // returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + this.hue + ", " + this.saturation + ", " + this.brightness + ")";
    }
    // is this color a shade of gray?
    public boolean isGrayscale() {
        return this.saturation == 0 || this.brightness == 0;
    }
    // returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("invalid color");

        int d1 = (int) (Math.pow(this.hue - that.hue, 2.0));
        int d2 = (int) (Math.pow(360 - Math.abs(this.hue - that.hue), 2.0));
        int d3 = (int) (Math.pow(this.saturation - that.saturation, 2.0));
        int d4 = (int) (Math.pow(this.brightness - that.brightness, 2.0));
        return Math.min(d1, d2) + d3 + d4;
    }
    // sample client
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB baseColor = new ColorHSB(h, s, b);

        String minColorName = "";
        ColorHSB minColor = null;
        int minDistance = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int h0 = StdIn.readInt();
            int s0 = StdIn.readInt();
            int b0 = StdIn.readInt();

            ColorHSB currentColor = new ColorHSB(h0, s0, b0);
            int distance = baseColor.distanceSquaredTo(currentColor);

            if (distance < minDistance) {
                minDistance = distance;
                minColor = currentColor;
                minColorName = colorName;
            }
        }
        StdOut.println(minColorName + " " + minColor.toString());
    }
}

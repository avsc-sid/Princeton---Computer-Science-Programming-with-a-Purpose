// Test Cases using GitBash Command Line
// java-introcs Checkerboard 8
// java-introcs Checkerboard 4
public class Checkerboard {
    public static void main(String[] args) {

        // read drawing scale
        int n = Integer.parseInt(args[0]);

        double drScale = n;
        StdDraw.setScale(0, n);

        double r = drScale / (2 * n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                double verticesX = drScale * i / n + r;
                double verticesY = drScale * j / n + r;
                StdDraw.filledSquare(verticesX, verticesY, r);
            }
        }
    }
}

// Test Cases
// java-introcs WorldMap < usa.txt
// java-introcs WorldMap < russia.txt
// java-introcs WorldMap < world.txt
public class WorldMap {
    public static void main(String[] args) {
        // read width & height
        int w = StdIn.readInt();
        int h = StdIn.readInt();

        StdDraw.setCanvasSize(w, h);

        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        StdDraw.enableDoubleBuffering();

        while (!StdIn.isEmpty()) {
            StdIn.readString();

            int nVertices = StdIn.readInt();
            double[] vertexX = new double[nVertices];
            double[] vertexY = new double[nVertices];

            for (int i = 0; i < nVertices; i++) {
                vertexX[i] = StdIn.readDouble();
                vertexY[i] = StdIn.readDouble();
            }

            StdDraw.polygon(vertexX, vertexY);
        }
        StdDraw.show();
    }
}

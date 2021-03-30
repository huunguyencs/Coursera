
public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int numVertex = StdIn.readInt();
            double[] x = new double[numVertex];
            double[] y = new double[numVertex];
            for (int i = 0; i < numVertex; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}

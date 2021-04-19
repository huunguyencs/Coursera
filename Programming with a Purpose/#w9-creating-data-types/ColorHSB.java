
public class ColorHSB {

    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return saturation == 0 || brightness == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int a = (int) Math.min(Math.pow(hue - that.hue, 2), Math.pow(360 - Math.abs(hue - that.hue), 2));
        int b = (int) Math.pow(saturation - that.saturation, 2);
        int c = (int) Math.pow(brightness - that.brightness, 2);
        return a + b + c;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);
        ColorHSB minDis = new ColorHSB(0, 0, 0);
        String name = "";
        int distance = Integer.MAX_VALUE;
        while (StdIn.hasNextLine()) {
            String n = StdIn.readString();
            int hTmp = StdIn.readInt();
            int sTmp = StdIn.readInt();
            int bTmp = StdIn.readInt();
            ColorHSB tmp = new ColorHSB(hTmp, sTmp, bTmp);
            int dis = color.distanceSquaredTo(tmp);
            if (dis < distance) {
                distance = dis;
                minDis = tmp;
                name = n;
            }
            StdIn.readLine();
        }
        StdOut.println(name + " " + minDis.toString());
    }
}

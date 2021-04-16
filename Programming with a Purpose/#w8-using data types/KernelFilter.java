import java.awt.Color;

public class KernelFilter {

    private static Picture convert(Picture picture, double[][] kernel) {
        int len = kernel[0].length;
        int par = len == 3 ? 1 : 4;
        int height = picture.height();
        int width = picture.width();
        Color[][] colors = new Color[width][height];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                colors[col][row] = picture.get(col, row);
            }
        }

        Picture result = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                double r = 0, g = 0, b = 0;
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        Color c = colors[(col - par + i + width) % width][(row - par + j + height) % height];
                        r += 1.0 * c.getRed() * kernel[i][j];
                        g += 1.0 * c.getGreen() * 1.0 * kernel[i][j];
                        b += 1.0 * c.getBlue() * 1.0 * kernel[i][j];
                    }
                }
                r = r < 0 ? 0 : (r > 255 ? 255 : r);
                g = g < 0 ? 0 : (g > 255 ? 255 : g);
                b = b < 0 ? 0 : (b > 255 ? 255 : b);
                result.set(col, row, new Color((int) Math.round(r), (int) Math.round(g), (int) Math.round(b)));
            }
        }
        return result;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] kernel = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        return convert(picture, kernel);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = { { 1.0 / 16, 1.0 / 8, 1.0 / 16 }, { 1.0 / 8, 1.0 / 4, 1.0 / 8 },
                { 1.0 / 16, 1.0 / 8, 1.0 / 16 } };
        return convert(picture, kernel);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
        return convert(picture, kernel);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };
        return convert(picture, kernel);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
        return convert(picture, kernel);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            kernel[i][i] = 1.0 / 9;
        }
        return convert(picture, kernel);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        Picture newPic = identity(pic);
        newPic.show();
        newPic = emboss(pic);
        newPic.show();
        newPic = gaussian(pic);
        newPic.show();
        newPic = laplacian(pic);
        newPic.show();
        newPic = sharpen(pic);
        newPic.show();
        newPic = motionBlur(pic);
        newPic.show();
    }
}

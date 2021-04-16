
public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] kernel = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

    }

    // Returns a new picture that applies a Gaussian blur filter to the given
    // picture.
    public static Picture gaussian(Picture picture) {
        double[][] kernel = { { 1 / 16, 1 / 8, 1 / 16 }, { 1 / 8, 1 / 4, 1 / 8 }, { 1 / 16, 1 / 8, 1 / 16 } };

    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] kernel = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };

    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] kernel = { { -1, -1, -1 }, { -1, 8, -1 }, { -1, -1, -1 } };

    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] kernel = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };

    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] kernel = new double[9][9];
        for (int i = 0; i < 9; i++) {
            kernel[i][i] = 1 / 9;
        }

    }

    // Test client (ungraded).
    public static void main(String[] args) {

    }
}

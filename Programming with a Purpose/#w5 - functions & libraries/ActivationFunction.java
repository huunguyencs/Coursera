
public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else if (x > 0) {
            return 1;
        }
        return Double.NaN;

    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (x >= Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x <= Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (x >= Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        if (x <= Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        } else if (x < 0) {
            return x + x * x / 4.0;
        } else if (x < 2) {
            return x - x * x / 4.0;
        } else if (x >= 2) {
            return 1;
        }
        return Double.NaN;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
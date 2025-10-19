/*
Test Cases
    java-introcs ActivationFunction 0.0
    heaviside(0.0) = 0.5
    sigmoid(0.0) = 0.5
    tanh(0.0) = 0.0
    softsign(0.0) = 0.0
    sqnl(0.0) = 0.0

    java-introcs ActivationFunction 1.0
    heaviside(1.0) = 1.0
    sigmoid(1.0) = 0.7310585786300049
    tanh(1.0) = 0.7615941559557649
    softsign(1.0) = 0.5
    sqnl(1.0) = 0.75

    java-introcs ActivationFunction -0.5
    heaviside(-0.5) = 0.0
    sigmoid(-0.5) = 0.3775406687981454
    tanh(-0.5) = -0.4621171572600098
    softsign(-0.5) = -0.3333333333333333
    sqnl(-0.5) = -0.4375
*/

public class ActivationFunction {

    // Returns the Heaviside funciton of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x < 0) return 0;
        if (x == 0) return 0.5;
        return 1;
    }

    // Returns the sigmoid funciton of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double r = 1 / (1 + Math.exp(-1 * x));
        return r;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x >= 20) return 1.0;
        if (x <= -20) return -1.0;

        return (Math.exp(x) - Math.exp(-1 * x)) / (Math.exp(x) + Math.exp(-1 * x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x == Double.POSITIVE_INFINITY) return 1;
        if (x == Double.NEGATIVE_INFINITY) return -1;

        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x <= -2) return -1;
        if (x > -2 && x < 0) return x + x * x / 4;
        if (x >= 0 && x < 2) return x - x * x / 4;
        return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {

        double x = Double.parseDouble(args[0]);

        StdOut.printf("heaviside(" + x + ")\t = \t" + heaviside(x) + "\n");
        StdOut.printf("sigmoid(" + x + ")\t = \t" + sigmoid(x) + "\n");
        StdOut.printf("tanh(" + x + ")\t = \t" + tanh(x) + "\n");
        StdOut.printf("softsign(" + x + ")\t = \t" + softsign(x) + "\n");
        StdOut.printf("sqnl(" + x + ")\t = \t" + sqnl(x) + "\n");
    }
}

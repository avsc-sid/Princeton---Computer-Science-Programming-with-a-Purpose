/*
 Test Cases
    java-introcs Divisors 1440 408
    gcd(1440, 408) = 24
    lcm(1440, 408) = 24480
    areRelativelyPrime(1440, 408) = false
    totient(1440) = 384
    totient(408) = 128

    java-introcs Divisors 987 610
    gcd(987, 610) = 1
    lcm(987, 610) = 602070
    areRelativelyPrime(987, 610) = true
    totient(987) = 552
    totient(610) = 240
 */

public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        while (absB != 0) {
            int mod = absA % absB;
            absA = absB;
            absB = mod;
        }

        return absA;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        if (gcd == 0) return 0;
        // Dividing first to preveent the overflow.
        return Math.abs(a) / gcd * Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integeres between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        if (n <= 0) return 0;

        int count = 1;
        for (int i = 2; i < n; i++) {
            if (areRelativelyPrime(n, i)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.printf("gcd(%d, %d)\t = \t%d\n", a, b, gcd(a, b));
        StdOut.printf("lcm(%d, %d)\t = \t%d\n", a, b, lcm(a, b));
        StdOut.printf("areRelativelyPrime(%d, %d)\t = \t" + areRelativelyPrime(a, b) + "\n", a, b);
        StdOut.printf("totient(%d)\t = \t%d\n", a, totient(a));
        StdOut.printf("totient(%d)\t = \t%d\n", b, totient(b));
    }
}

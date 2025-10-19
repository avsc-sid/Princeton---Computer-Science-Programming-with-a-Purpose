// Generalized harmonic numbers
// takes two integer command-line arguments n and r and uses a for loop to compute the nth generalized harmonic number of order r
// Test cases
// 1 1 : 1.0
// 2 1 : 1.5
// 3 1 : 1.83333333
// 3 2 : 1.36111111111112
public class GeneralizedHarmonic {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / Math.pow(i, r);
        }
        System.out.println(sum);
        return;
    }
}

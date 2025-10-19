// Test Cases using GitBash Command Line
// java-introcs ShannonEntropy 2 < fair-coin.txt
// java-introcs ShannonEntropy 6 < loaded-die.txt     :: 1.8750
// java-introcs DiscreteDistribution 1000000 80 20 | java-introcs ShannonEntropy 2  :: 0.7221
// java-introcs DiscreteDistribution 1000000 80 20 | java-introcs ShannonEntropy 2  :: 0.7217
public class ShannonEntropy {
    public static void main(String[] args) {
        double nCount = 0;
        double vEntropy = 0.0;

        int m = Integer.parseInt(args[0]);
        int[] arrV = new int[m + 1];

        while (!StdIn.isEmpty()) {
            int iValue = StdIn.readInt();
            arrV[iValue] += 1;
            nCount += 1;
        }

        int i = 0;
        for (i = 1; i <= m; i++) {
            double calcE = 0;
            if (arrV[i] != 0) {
                calcE = -(arrV[i] / nCount * (Math.log(arrV[i] / nCount) / Math.log(2)));
            }
            vEntropy += calcE;
        }
        StdOut.printf("%.4f \n", vEntropy);
    }
}

// Test Cases
// 25 1 1 1 1 1 1 : 5 2 4 4 5 5 4 3 4 3 1 5 2 4 2 6 1 3 6 2 3 2 4 1 4
// 25 10 10 10 10 10 50 : 3 6 6 1 6 6 2 4 6 6 3 6 6 6 6 4 5 6 2 2 6 6 2 6 2
// 100 301 176 125 97 79 67 58 51 46 : long list
public class DiscreteDistribution {
    public static void main(String[] args) {
        int lArgs = args.length;
        int cumArgs = 0;
        int nRandom = 0;

        int m = Integer.parseInt(args[0]);
        int[] sumArgs = new int[lArgs];
        sumArgs[0] = 0;

        // cumulative sum
        for (int i = 1; i < lArgs; i++) {
            cumArgs = cumArgs + Integer.parseInt(args[i]);
            sumArgs[i] = cumArgs;
        }

        int lmt = sumArgs[sumArgs.length - 1];
        int nPrint = 0;
        for (int j = 0; j < m; j++) {
            nRandom = (int) Math.floor(Math.random() * lmt);
            for (int i = 1; i < sumArgs.length; i++) {
                if (sumArgs[i - 1] <= nRandom && nRandom < sumArgs[i]) {
                    nPrint = nPrint + 1;
                    System.out.printf("%d ", i);
                    if (nPrint == 25)
                        {
                            System.out.printf("%n");
                            nPrint = 0;
                        }
                }
            }

        }
    }
}

// RandomWalkers
// Test Cases
// 5 1000000 : 14.98188
// 10 100000 : 59.37386
// 160 100000 : 15113.61108
public class RandomWalkers {
    public static void main(String[] args) {

        int mDistance = Integer.parseInt(args[0]);
        int nTrials = Integer.parseInt(args[1]);

        double avgSteps = 0;
        int sumSteps = 0;

        for (int i = 0; i < nTrials; i++) {

            int nRandom = 0;
            int cStep = 0;
            int x = 0;
            int y = 0;

            while (Math.abs(x) + Math.abs(y) != mDistance) {

                nRandom = 1 + (int) (Math.random() * 4);
                switch (nRandom) {
                    case 1: y = y + 1; break;
                    case 2: y = y - 1; break;
                    case 3: x = x + 1; break;
                    default: x = x - 1; break;
                }
                cStep++;
            }
            sumSteps = sumSteps + cStep;
        }

        avgSteps = sumSteps * (1.00) / nTrials * (1.00);
        System.out.printf("average number of steps = %f", avgSteps);
    }
}

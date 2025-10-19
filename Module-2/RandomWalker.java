// RandomWalker.java
// Input: integer r (simulates the motion of a random walk)
// Test Cases
// 5 : Output
public class RandomWalker {
    public static void main(String[] args) {

        int mDistance = Integer.parseInt(args[0]);

        int nRandom = 0;
        int cStep = 0;
        int x = 0;
        int y = 0;
        while (Math.abs(x) + Math.abs(y) != mDistance) {
            System.out.printf("(%d, %d) %n", x, y, nRandom);
            nRandom = 1 + (int) (Math.random() * 4);
            switch (nRandom) {
                case 1: y = y + 1; break;
                case 2: y = y - 1; break;
                case 3: x = x + 1; break;
                default: x = x - 1; break;
            }
            cStep++;
        }
        System.out.printf("(%d, %d) %n", x, y);
        System.out.printf("steps = %d %n", cStep);
    }
}

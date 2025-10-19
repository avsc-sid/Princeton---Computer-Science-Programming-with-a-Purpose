// Test Cases
// 3 ::
// Move disc 1 from A to B
// Move disc 2 from A to C
// Move disc 3 from A to D
// Move disc 2 from C to D
// Move disc 1 from B to D
public class RevesPuzzle {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        revers(n, "A", "B", "C", "D");
    }

    private static void revers(int n, String sFrom, String sT1, String sT2, String sTo) {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        revers(k, sFrom, sTo, sT2, sT1);

        hanoi(n, k, sFrom, sT2, sTo);

        revers(k, sT1, sFrom, sT2, sTo);
    }

    private static void hanoi(int n, int k, String sFrom, String temp, String sTo) {
        if (n == k) return;
        hanoi(n - 1, k, sFrom, sTo, temp);
        StdOut.println("Move disc " + n + " from " + sFrom + " to " + sTo);
        hanoi(n - 1, k, temp, sFrom, sTo);
    }
}

// Test Cases
// 5 4 3
// 9 9 10
public class Minesweeper {
    public static void main(String[] args) {
        final int MAX_CELLNUMBER = 99;
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int maxSize = n * m;
        int nCount = 0;
        int[][] cellGrid = new int[n][m];
        int[] xLine = new int[k];
        int[] yLine = new int[k];
        int nRandom = 0;
        int cellLocation = 0;
        while (nCount < k) {
            nRandom = (int) Math.floor(Math.random() * maxSize);
            int y = nRandom / m;
            int x = nRandom % m;
            if (cellGrid[y][x] == 0) {
                cellGrid[y][x] = MAX_CELLNUMBER;
                nCount++;
                xLine[cellLocation] = x;
                yLine[cellLocation] = y;
                cellLocation++;
            }
        }
        // Fill the array
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (cellGrid[y][x] != MAX_CELLNUMBER) {
                    for (int nIndex = 0; nIndex < k; nIndex++) {
                        if (Math.abs(x - xLine[nIndex]) <= 1 && Math.abs(y - yLine[nIndex]) <= 1) { cellGrid[y][x] = cellGrid[y][x] + 1; }
                    }
                }
            }
        }
        // Print Output
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (cellGrid[y][x] == MAX_CELLNUMBER) { System.out.printf("%s  ", "*"); }
                else { System.out.printf("%s  ", cellGrid[y][x]); }
            }
            System.out.printf("%n");
        }
   }
}

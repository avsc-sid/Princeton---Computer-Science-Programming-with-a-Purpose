// BandMatrix.java
// Input: 2 integer command-line arguments n and width
// Test Cases n=8 width=0
// 8 0 : Output
//         *  0  0  0  0  0  0  0
//         0  *  0  0  0  0  0  0
//         0  0  *  0  0  0  0  0
//         0  0  0  *  0  0  0  0
//         0  0  0  0  *  0  0  0
//         0  0  0  0  0  *  0  0
//         0  0  0  0  0  0  *  0
//         0  0  0  0  0  0  0  *
// 8 1 : Output
//         *  *  0  0  0  0  0  0
//         *  *  *  0  0  0  0  0
//         0  *  *  *  0  0  0  0
//         0  0  *  *  *  0  0  0
//         0  0  0  *  *  *  0  0
//         0  0  0  0  *  *  *  0
//         0  0  0  0  0  *  *  *
//         0  0  0  0  0  0  *  *
// 8 2 : Output
//         *  *  *  0  0  0  0  0
//         *  *  *  *  0  0  0  0
//         *  *  *  *  *  0  0  0
//         0  *  *  *  *  *  0  0
//         0  0  *  *  *  *  *  0
//         0  0  0  *  *  *  *  *
//         0  0  0  0  *  *  *  *
//         0  0  0  0  0  *  *  *
// 8 3 : Output
//         *  *  *  *  0  0  0  0
//         *  *  *  *  *  0  0  0
//         *  *  *  *  *  *  0  0
//         *  *  *  *  *  *  *  0
//         0  *  *  *  *  *  *  *
//         0  0  *  *  *  *  *  *
//         0  0  0  *  *  *  *  *
//         0  0  0  0  *  *  *  *
public class BandMatrix {
    public static void main(String[] args) {
        // Get input arguments
        int n = Integer.parseInt(args[0]);
        int w = Integer.parseInt(args[1]);
        int diagLocation = 1;

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (Math.abs(c - diagLocation) <= w) {
                    System.out.printf("*  ");
                } else {
                    System.out.printf("0  ");
                }
            }
            diagLocation = diagLocation + 1;

            // print one blank line
            System.out.println("");
        }

    }
}

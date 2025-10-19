// Assignment 3 - RightTriangle
// test values: 3 4 5 true
// test values: 13 12 5 true
// test values: 1 2 3 false
// test values: -3 4 -5 false
// test values: 43333344 35718 9424473 false

public class RightTriangle {
    public static void main(String[] args) {
        // Convert input command line arguments to integers
        int s1 = Integer.parseInt(args[0]);
        int s2 = Integer.parseInt(args[1]);
        int s3 = Integer.parseInt(args[2]);

        // Using Pythagorean theorem for right angle triangle a,b,c
        // If a*a + b*b = c*c then it is right angle triangle
        // without using conditionals or array, sorting is not possible
        // So, verify all 3 possibilities.
        double s1sq = s1 * s1;
        double s2sq = s2 * s2;
        double s3sq = s3 * s3;

        double s12sq = s1sq + s2sq;
        double s13sq = s1sq + s3sq;
        double s23sq = s2sq + s3sq;

        // Verify that all the input arguments are >0
        boolean verifyRightAngleTriangle = (s1 > 0 & s2 > 0 & s3 > 0 & (s12sq == s3sq | s13sq == s2sq | s23sq == s1sq));
        // System.out.println("Input sides: " + s1 + ", " + s2 + ", " + s3);

        // Output the result
        System.out.println(verifyRightAngleTriangle);

        return;
    }
}

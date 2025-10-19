// Assignment 4 - GreatCircle
// test sample: 40.35 74.65 48.87 -2.33  Result: 5902.927099258561
// test sample: 60.0 15.0 120.0 105.0    Result: 4604.53989281927

public class GreatCircle {
    public static void main(String[] args) {

        // Convert input command line arguments latitudes, longitudes as decimals (degrees)
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);

        double rx1 = Math.toRadians(x1);
        double ry1 = Math.toRadians(y1);
        double rx2 = Math.toRadians(x2);
        double ry2 = Math.toRadians(y2);

        double r = 6371.0; // earth radius in km
        double s1 = Math.sin((rx2-rx1)/2.0);
        double s2 = Math.sin((ry2-ry1)/2.0);
        double c1 = Math.sqrt(s1*s1+Math.cos(rx1)*Math.cos(rx2)*s2*s2);
        double distPoints = 2.0*r*Math.asin(c1);
        // Print distance lattitudes, longitudes
        // System.out.println("Supplied lattitude and longitude points: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")");
        // System.out.println("Earth's distance between entered lattitude and longitude points: " + distPoints + " km");
        System.out.println(distPoints + " kilometers");
    }

}

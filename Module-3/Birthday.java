// Test Cases
// 2 integer command-line arguments n, trials
/* 365 1000000
   Output
        1	0	    0.0
        2	2710	0.00271
        3	5547	0.008257
        4	8105	0.016362
        5	10776	0.027138
        6	13413	0.040551
        7	15782	0.056333
        8	17816	0.074149
        9	20283	0.094432
        10	22297	0.116729
        11	24105	0.140834
        12	26013	0.166847
        13	27247	0.194094
        14	28405	0.222499
        15	29873	0.252372
        16	30447	0.282819
        17	31445	0.314264
        18	31837	0.346101
        19	32559	0.37866
        20	32244	0.410904
        21	32357	0.443261
        22	32020	0.475281
        23	31667	0.506948
*/
public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int totalTrails = Integer.parseInt(args[1]);
        int nTrails = 0;
        int[] totalPeople = { 0 };

        for (int trials = 0; trials < totalTrails; trials++) {
            int[] room = new int[n];
            int nPeople = 0;
            while (room[nTrails] != 2) {
                nTrails = (int) Math.floor(Math.random() * n);
                room[nTrails] = room[nTrails] + 1;
                nPeople++;
            }

            int[] arrayPeople = new int[nPeople + 1];
            if (totalPeople.length <= nPeople) {
                for (int i = 0; i < totalPeople.length; i++) {
                    arrayPeople[i] = totalPeople[i];
                }
                totalPeople = arrayPeople;
            }
            totalPeople[nPeople] = totalPeople[nPeople] + 1;
        }
        int i = 1;
        double vAverage = 0;
        double vSum = 0.0;
        for (i = 1; i < totalPeople.length; i++) {
            vSum = vSum + totalPeople[i];
            vAverage = vSum / totalTrails;
            System.out.printf("%d %d %f %n", i, totalPeople[i], vAverage);
            if (vAverage >= 0.5) { break; }
        }
    }
}

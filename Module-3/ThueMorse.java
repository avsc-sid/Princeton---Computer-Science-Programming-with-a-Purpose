// Test Cases
// 8 : output 8x8 matrix
public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] arrayResult = { 0 };
        while (arrayResult.length < n) {
            int[] numList = arrayResult;
            int newLongitud = numList.length * 2;
            int[] calcnumList = new int[numList.length * 2];
            for (int j = numList.length; j < newLongitud; j++) {
                calcnumList[j - numList.length] = numList[j - numList.length];
                calcnumList[j] = numList[j - numList.length] == 0 ? 1 : 0;
            }
            arrayResult = calcnumList;
        }
        int[] linea = arrayResult;
        //  Generate Morse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String show = linea[i] == linea[j] ? "+  " : "-  ";
                System.out.print(show);
            }
            System.out.println("");
        }
    }

}

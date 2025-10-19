/*
    Test Cases




*/
public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amp = new double[a.length];
        if (alpha < 0) alpha = 0;

        for (int i = 0; i < a.length; i++) {
            amp[i] = alpha * a[i];
        }
        return amp;
    }

    // Returns a new array that is the reverse of a[]
    public static double[] reverse(double[] a) {
        int len = a.length;
        double[] rev = new double[len];
        for (int i = 0; i < len; i++) {
            rev[i] = a[i];
        }
        for (int i = 0; i < len / 2; i++) {
            double temp = rev[i];
            rev[i] = rev[len - 1 - i];
            rev[len - 1 - i] = temp;
        }
        return rev;
    }

    // Returns a new array that is the concatenation of a[] and b[]
    public static double[] merge(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        int len = m + n;
        double[] c = new double[len];
        for (int i = 0; i < m; i++) c[i] = a[i];
        for (int i = m; i < len; i++) c[i] = b[i - m];

        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int m = a.length;
        int n = b.length;
        boolean isALongerThanB = m > n;
        int len = isALongerThanB ? m : n;

        double[] c = new double[len];
        for (int i = 0; i < len; i++) {
            if (i < Math.min(m, n)) {
                c[i] = a[i] + b[i];
            }
            else {
                if (isALongerThanB) {
                    c[i] = a[i];
                }
                else {
                    c[i] = b[i];
                }
            }
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int sampleLen = (int) Math.floor(a.length / alpha);
        double[] c = new double[sampleLen];

        for (int i = 0; i < sampleLen; i++) {
            c[i] = a[(int) Math.floor(i * alpha)];
        }

        return c;
    }

    public static void main(String[] args) {
        String[] files = new String[] {
                "beatbox.wav", "exposure.wav", "silence.wav", "piano.wav", "harp.wav", "cow.wav",
                "singer.wav",
        };
        double[][] playList = new double[files.length][];

        playList[0] = mix(StdAudio.read("beatbox.wav"), StdAudio.read("piano.wav"));

        for (int i = 0; i < playList.length; i++) {
            if (i % 2 == 0) {
                playList[i] = reverse(
                        mix(StdAudio.read(files[i]), changeSpeed(StdAudio.read(files[0]), 2)));
            }
            else {
                playList[i] = amplify(merge(StdAudio.read(files[i]), StdAudio.read(files[i - 1])),
                        1.25);
            }
        }

        for (int i = 0; i < playList.length; i++) {
            for (int j = 0; j < playList[i].length; j++) {
                playList[i][j] = playList[i][j] > 1.0 ? 1.0 :
                        (playList[i][j] < -1 ? -1.0 : playList[i][j]);
            }
            StdAudio.play(playList[i]);
        }
    }
}

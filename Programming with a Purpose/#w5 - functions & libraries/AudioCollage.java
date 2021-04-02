public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] amp = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amp[i] = a[i] * alpha;
        }
        return amp;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int n = a.length;
        double[] r = new double[n];
        for (int i = 0; i < n; i++) {
            r[i] = a[n - i - 1];
        }
        return r;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int la = a.length;
        int lb = b.length;
        double[] m = new double[la + lb];
        for (int i = 0; i < la; i++) {
            m[i] = a[i];
        }
        for (int i = la; i < la + lb; i++) {
            m[i] = b[i - la];
        }
        return m;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int la = a.length;
        int lb = b.length;
        boolean aLongThanb = la > lb;
        int lengthMix = aLongThanb ? la : lb;
        double[] m = new double[lengthMix];
        for (int i = 0; i < Math.min(la, lb); i++) {
            m[i] = a[i] + b[i];
        }
        if (aLongThanb) {
            for (int i = lb; i < lengthMix; i++) {
                m[i] = a[i];
            }
        } else {
            for (int i = la; i < lengthMix; i++) {
                m[i] = b[i];
            }
        }
        return m;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newLength = (int) (a.length / alpha);
        double[] c = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            c[i] = a[(int) (i * alpha)];
        }
        return c;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");

        double[] ampli = amplify(beatbox, 2);
        StdAudio.play(ampli);

        double[] rev = reverse(chimes);
        StdAudio.play(rev);

        double[] mer = merge(chimes, buzzer);
        StdAudio.play(mer);

        double[] mi = mix(cow, dialup);
        StdAudio.play(mi);

        double[] changeS = changeSpeed(chimes, 2);
        StdAudio.play(changeS);
    }
}
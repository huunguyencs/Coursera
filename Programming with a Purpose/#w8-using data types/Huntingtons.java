
public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int len = dna.length();
        int maxRepeats = 0;
        int currIndex = dna.indexOf("CAG", 0);
        while (currIndex != -1) {
            int count = 1;
            int curr = currIndex + 3;
            boolean isExit = false;
            while (curr <= len - 3 && !isExit) {
                if (!dna.substring(curr, curr + 3).equals("CAG")) {
                    isExit = true;
                } else {
                    count++;
                }
                curr += 3;
            }
            maxRepeats = maxRepeats < count ? count : maxRepeats;
            currIndex = dna.indexOf("CAG", curr - 2);
        }
        return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines)
    // removed.
    public static String removeWhitespace(String s) {
        String res = s;
        res = res.replace(" ", "");
        res = res.replace("\n", "");
        res = res.replace("\t", "");
        return res;
    }

    // Returns one of these dianoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk" of "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10) {
            return "not human";
        } else if (maxRepeats < 36) {
            return "normal";
        } else if (maxRepeats < 40) {
            return "high risk";
        } else if (maxRepeats < 181) {
            return "Huntington's";
        } else {
            return "not human";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        String dna = in.readAll();
        dna = removeWhitespace(dna);
        int maxRepeats = maxRepeats(dna);
        System.out.println("max repeats = " + maxRepeats);
        System.out.println(diagnose(maxRepeats));
    }
}

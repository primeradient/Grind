package interviewBit.strings;

public class StrStr {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String haystack, final String needle) {

        int hN, nN;

        hN = haystack.length();
        nN = needle.length();

        if (hN == 0 || nN == 0)
            return -1;

        if (nN > hN)
            return -1;

        int R = 256;

        int dfa[][] = new int[nN + 1][R];

        dfa[0][needle.charAt(0)] = 1;

        int X = 0;

        for (int i = 1; i < nN; i++) {
            for (int r = 0; r < R; r++) {
                dfa[i][r] = dfa[X][r];
            }
            dfa[i][needle.charAt(i)] = i + 1;
            X = dfa[X][needle.charAt(i)];
        }


        X = 0;

        for (int i = 0; i < hN; i++) {
            X = dfa[X][haystack.charAt(i)];
            if (X == nN)
                return i - nN + 1;
        }

        return -1;

    }

    public static void main(String [] args) {
        System.out.println(new StrStr().strStr("bighit","bit"));
    }
}

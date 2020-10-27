package dp;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        dp = new int[M][256];
        dp[0][pat.charAt(0)] = 1;
        int X = 0;
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 256; j++) {
                dp[i][j] = dp[X][j];
            }
            dp[i][pat.charAt(i)] = i + 1;
            X = dp[X][pat.charAt(i)];
        }
    }
    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == M) return i - M + 1;
        }
        return -1;
    }


}

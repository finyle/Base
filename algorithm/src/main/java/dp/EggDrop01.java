package dp;

import sun.font.FontRunIterator;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class EggDrop01 {

    public static int eggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        int k = 2, n = 6;
        System.out.println(eggDrop(k, n));
    }
}

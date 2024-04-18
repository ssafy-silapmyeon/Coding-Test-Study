package footdev._6주차;

class Solution {

    static final int VALID = 1;
    static final int NOT_VALID = -1;
    static final long MAX_VALUE = 1000000007;

    long[][] dp;
    int[][] map;
    int[][] v;

    public long solution(int m, int n, int[][] puddles) {
        dp = new long[101][101];
        map = new int[n + 1][m + 1];
        v = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            if (puddles.length == 1 && puddles[0].length == 0) break;
            map[puddles[i][1]][puddles[i][0]] = NOT_VALID;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    dp[1][1] = 1;
                    continue;
                }
                if (map[i][j] == NOT_VALID) {
                    dp[i][j] = NOT_VALID;
                    continue;
                }
                if (i > 1) {
                    if (dp[i - 1][j] != NOT_VALID) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
                if (j > 1) {
                    if (dp[i][j - 1] != NOT_VALID) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }

                dp[i][j] = dp[i][j] % MAX_VALUE;
            }
        }

        return dp[n][m];
    }
}

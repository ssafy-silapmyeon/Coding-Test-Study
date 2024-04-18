package footdev._6주차;

import java.util.Arrays;

class PGS_정수_삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[i + 1];
        }

        for (int i = 0; i < dp.length; i++) {
            int len = dp[i].length;
            for (int j = 0; j < len; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = triangle[0][0];
                    continue;
                }

                if (j > 0 && j < len - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                }

                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
            }
        }
        return Arrays.stream(dp[dp.length - 1])
                .max()
                .getAsInt();
    }
}
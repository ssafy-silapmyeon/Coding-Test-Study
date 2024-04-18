package footdev._12주차;

import java.io.*;

public class BOJ_LCS {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int aLen, bLen;
    static char[] a, b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        //초기화
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        aLen = a.length;
        bLen = b.length;
        dp = new int[aLen + 1][bLen + 1];

        //로직
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                max = Math.max(max, dp[i][j]);
            }
        }

        //출력
        System.out.println(max);
    }
}
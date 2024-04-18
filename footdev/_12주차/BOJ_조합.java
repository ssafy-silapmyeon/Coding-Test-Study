package footdev._12주차;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BOJ_조합 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new BigInteger[n + 1][m + 1];

        for (BigInteger[] arr : dp) {
            Arrays.fill(arr, new BigInteger("0"));
        }

        //nCm = (n - 1 C m - 1) + (n - 1 C m)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j == 1) {
                    dp[i][1] = BigInteger.valueOf(i);
                    continue;
                }
                dp[i][j] = new BigInteger(String.valueOf(dp[i - 1][j - 1].add(dp[i - 1][j])));
            }
        }

        System.out.println(dp[n][m]);
    }
}

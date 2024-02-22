package footdev._11주차;

import java.io.*;
import java.util.*;

public class BOJ_동전_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static long[] coins, dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new long[n];
        dp = new long[10000001];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            coins[i] = Long.parseLong(br.readLine());
            dp[(int) coins[i]] = 1;
        }

        //로직
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.min(dp[j] + dp[i - j], dp[i]);
            }
        }

        //출력
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}

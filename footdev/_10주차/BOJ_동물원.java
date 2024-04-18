package footdev._10주차;

import java.util.*;
import java.io.*;

public class BOJ_동물원 {

    static final int MOD = 9901;
    static Scanner sc = new Scanner(System.in);
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        dp = new long[n + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        //로직
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        //출력
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
    }
}

package footdev._13주차;

import java.io.*;

public class BOJ_123_더하기_3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int t, n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        //로직
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            dp = new long[n + 1];

            for (int i = 4; i <= n; i++) {
                if (i == 1) dp[1] = 1;
                else if (i == 2) dp[2] = 2;
                else if (i == 3) dp[3] = 4;
                else dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            }
            sb.append(dp[n]).append("\n");
        }

        //출력
        System.out.println(sb.toString());
    }
}

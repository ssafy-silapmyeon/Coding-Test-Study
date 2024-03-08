package footdev._13주차;

import java.io.*;
import java.util.*;

public class BOJ_자두나무 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int t, w, move, curr;
    static byte[] plums;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        //초기화
        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        plums = new byte[t];
        dp = new int[t + 1][w + 1];

        for (int i = 0; i < t; i++) {
            plums[i] = Byte.parseByte(br.readLine());
        }

        //로직
        if (plums[0] == 1) {
            dp[1][0] = 1;
        } else {
            dp[1][1] = 1;
        }

        for (int i = 1; i <= t; i++) {
            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    if (plums[i - 1] == 1) dp[i][j]++;
                    continue;
                }
                if (j % 2 == 0) {
                    if (plums[i - 1] == 1) dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1);
                } else  {
                    if (plums[i - 1] == 2) dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        //출력
        System.out.println(dp[t][w]);
    }
}

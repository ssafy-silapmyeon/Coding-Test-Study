package footdev._7주차;

import java.util.*;
import java.io.*;

public class BOJ_퇴사_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        t = new int[N + 1];
        p = new int[N + 1];
        dp = new int[1500001];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        for (int i = 1; i <= N; i++) {
           dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
           dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[N + 1]);
    }
}

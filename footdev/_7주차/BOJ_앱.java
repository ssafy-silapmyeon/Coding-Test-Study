package footdev._7주차;

import java.io.*;
import java.util.*;

public class BOJ_앱 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] m, c;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        m = new int[N + 1];
        c = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            c[i] = stoi(st.nextToken());
        }

        dp = new int[N + 1][Arrays.stream(c).sum() + 1];

        //로직
        // i = i번 째 앱, j = 쓴 비용
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < dp[0].length; j++) {
               dp[i][j] = dp[i - 1][j];
               if (j - c[i] >= 0) {
                   dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c[i]] + m[i]);
               }
            }
        }

        int res = 0;
        L:for (int i = 0; i < dp[0].length; i++) {
            for (int j = 0; j <= N; j++) {
                if (dp[j][i] >= M) {
                    res = i;
                    break L;
                }
            }
        }

        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(res);
    }

    static int stoi(String s) {return Integer.parseInt(s);}
}

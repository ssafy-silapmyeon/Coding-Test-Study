package footdev._8주차;

import java.io.*;
import java.util.*;

public class BOJ_호텔 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int c, n;
    static int[][] in;
    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {

        //초기화
        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        in = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            in[i][0] = Integer.parseInt(st.nextToken());
            in[i][1] = Integer.parseInt(st.nextToken());
        }

        //로직
        for (int i = 0; i < 100001; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (i - in[j][0] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - in[j][0]] + in[j][1]);
                }
            }
        }

        //출력
        for (int i = 0; i < 100001; i++) {
            if (dp[i] >= c) {
                System.out.println(i);
                break;
            }
        }
    }
}

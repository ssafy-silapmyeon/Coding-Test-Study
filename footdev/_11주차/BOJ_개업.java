package footdev._11주차;

import java.io.*;
import java.util.*;

public class BOJ_개업 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long[] dp, woks;

    public static void main(String[] args) throws IOException {

        //초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new long[10000001];
        woks = new long[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int size = Integer.parseInt(st.nextToken());
            woks[size]++;
        }

        //로직
        /*
        dp[만든 짜장면 수] = 짜장면을 만드는데 필요한 최소 횟수
        j == i - j 일 때, 동일한 웍이 2개 이상이면 1번에 가능
        j != i - j 더라도, 둘 다 1개 이상이면 1번에 가능
        */
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            if (woks[i] > 0) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= i / 2; j++) {
                if (j == i - j && woks[j] > 1) {
                    dp[i] = 1;
                    break;
                }
                else if (j != i - j && (woks[j] > 0 && woks[i - j] > 0)){
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }

        //출력
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}

import java.util.*;
import java.io.*;

public class BOJ_로또 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int t, n, m;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            dp = new long[n + 1][m + 1];

            //로직
            //기저상태 설정
            for (int i = 1; i <= m; i++) {
                dp[1][i] = i;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
                }
            }

            //답 저장
            sb.append(dp[n][m] + "\n");
        }

        //출력
        System.out.println(sb.toString());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] arr = new int[n + 1][3];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n + 1][3];

            dp[1][1] = arr[1][1];
            dp[1][2] = dp[1][1] + arr[1][2];
            dp[2][0] = dp[1][1] + arr[2][0];
            dp[2][1] = Math.min(dp[2][0], Math.min(dp[1][1], dp[1][2])) + arr[2][1];
            dp[2][2] = Math.min(dp[2][1], Math.min(dp[1][1], dp[1][2])) + arr[2][2];

            for (int i = 3; i <= n; i++) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][0];
                dp[i][1] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), Math.min(dp[i - 1][2], dp[i][0])) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][1])) + arr[i][2];
            }

            sb.append(idx).append(".").append(" ").append(dp[n][1]).append("\n");
            idx++;
        }

        System.out.println(sb);
    }
}

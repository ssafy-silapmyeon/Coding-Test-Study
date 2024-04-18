package footdev._12주차;

import java.util.*;
import java.io.*;

public class BOJ_점프 {

    static final int[] dx = {1, 0};
    static final int[] dy = {0, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] m;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //로직
        dfs(0, 0);

        long max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

    static long dfs(int x, int y) {
        if (x == n - 1 && y == n - 1) {
            return 1;
        }

        if (dp[x][y] > 0) return dp[x][y];
        if (m[x][y] == 0) return 0;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * m[x][y];
            int ny = y + dy[i] * m[x][y];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            dp[x][y] += dfs(nx, ny);
        }

        return dp[x][y];
    }
}
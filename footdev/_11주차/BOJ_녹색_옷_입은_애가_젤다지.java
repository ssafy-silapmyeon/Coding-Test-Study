package footdev._11주차;

import java.io.*;
import java.util.*;

public class BOJ_녹색_옷_입은_애가_젤다지 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] m = new int[n][n];
            int[][] dp = new int[n][n];

            for (int[] a : dp) {
                Arrays.fill(a, Integer.MAX_VALUE);
            }
            PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = 0;
            pq.add(new Edge(0, 0, m[0][0]));
            //로직
            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                for (int i = 0; i < 4; i++)  {
                    int nx = curr.x + dx[i];
                    int ny = curr.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (curr.w + m[nx][ny] < dp[nx][ny]) {
                        dp[nx][ny] = curr.w + m[nx][ny];
                        pq.add(new Edge(nx, ny, curr.w + m[nx][ny]));
                    }
                }
            }

            sb.append("Problem " + t++ + ": " + dp[n - 1][n - 1]).append("\n");
        }

        //출력
        System.out.print(sb.toString());
    }
}

class Edge {
    int x;
    int y;
    int w;

    public Edge(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

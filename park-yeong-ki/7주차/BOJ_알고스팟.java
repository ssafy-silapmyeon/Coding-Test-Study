import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] map;
    static class Point implements Comparable<Point>{
        int r, c, w;

        Point(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        String row;
        for (int i = 0; i < N; i++) {
            row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(dijkstra(new Point(0, 0, 0)));
    }

    static int dijkstra(Point start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];

        pq.add(start);

        Point current;
        while (!pq.isEmpty()) {
            current = pq.poll();

            if (current.r == N - 1 && current.c == M - 1) {
                return current.w;
            }

            if (visited[current.r][current.c]) continue;
            visited[current.r][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == 0){
                    pq.add(new Point(nr, nc, current.w));
                } else if (map[nr][nc] == 1) {
                    pq.add(new Point(nr, nc, current.w + 1));
                }
            }
        }

        return -1;
    }
}

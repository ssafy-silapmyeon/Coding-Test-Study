import java.io.*;
import java.util.*;

public class Main {
    static int K, answer;
    static ArrayList<Point>[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        points = new ArrayList[K + 1];
        for (int i = 1; i <= K; i++) {
            points[i] = new ArrayList<>();
        }

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            points[k].add(new Point(x, y));
        }

        answer = 4000001;
        for (Point p : points[1]) {
            dfs(1, p.i, p.j, p.i, p.j);
        }

        System.out.println(answer);
    }

    static void dfs(int color, int i1, int j1, int i2, int j2) {
        if (color == K + 1) {
            answer = Math.min(answer, (i2 - i1) * (j2 - j1));
            return;
        }

        for (Point p : points[color]) {
            int x1 = Math.min(i1, p.i);
            int y1 = Math.min(j1, p.j);
            int x2 = Math.max(i2, p.i);
            int y2 = Math.max(j2, p.j);

            if (answer > (x2 - x1) * (y2 - y1)) {
                dfs(color + 1, x1, y1, x2, y2);
            }
        }
    }

    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

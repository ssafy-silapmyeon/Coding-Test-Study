import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int r, c;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        int ans = 0;
        while (remove() > 0) {
            move();
            ans++;
        }
        System.out.println(ans);
    }

    static int bfs(Point start) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.r][start.c] = true;

        List<Point> pList = new ArrayList<>();
        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            pList.add(current);

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] != map[start.r][start.c]) continue;

                queue.add(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }

        if (pList.size() >= 4) {
            for (Point p : pList) {
                map[p.r][p.c] = '.';
            }
            return pList.size();
        }

        return 0;
    }

    static int remove() {
        visited = new boolean[r][c];
        int rCnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == '.') continue;
                rCnt += bfs(new Point(i, j));
            }
        }

        return rCnt;
    }

    static void move() {
        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '.') continue;
                down(i, j);
            }
        }
    }

    static void down(int row, int col) {
        while (row < r-1 && map[row+1][col] == '.') {
            map[row + 1][col] = map[row][col];
            map[row][col] = '.';
            row++;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        r = 12;
        c = 6;
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}

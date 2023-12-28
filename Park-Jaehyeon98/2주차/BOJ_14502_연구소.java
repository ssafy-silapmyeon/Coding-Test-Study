import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// bfs를 돌리기 위한 Point 클래스 선언
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BOJ_14502_연구소 {

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] y = { -1, 1, 0, 0 };
    static int[] x = { 0, 0, -1, 1 };
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(ans);
    }

    public static void dfs(int cnt) {

        // 3개씩 조합이 완성되면 bfs를 돌린다.
        if (cnt == 3) {
            bfs();
            return;
        }

        // 벽 3개씩을 랜덤으로 뽑기 위한 조합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        // 원본을 훼손할 수 없기에 copy_map을 만든다.
        int[][] copy_map = new int[n][m];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy_map[i][j] = map[i][j];
            }
        }

        // 바이러스가 있는 곳을 queue에 add해줘서 bfs를 돌딘다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy_map[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + y[i];
                int nx = now.x + x[i];
                if (nx >= 0 && ny >= 0 && ny < n && nx < m) {
                    // 빈칸 0인 경우 바이러스가 퍼지므로 2로 바꿔주고 queue에 add해준다.
                    if (copy_map[ny][nx] == 0) {
                        copy_map[ny][nx] = 2;
                        q.add(new Point(ny, nx));
                    }
                }
            }
        }
        count(copy_map);
    }

    // 안전 영역의 크기를 구해서 비교한다.
    public static void count(int[][] copy_map) {
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy_map[i][j] == 0) {
                    tmp++;
                }
            }
        }
        ans = Math.max(ans, tmp);
    }
}
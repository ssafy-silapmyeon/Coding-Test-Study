import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int R, C, ts, tw;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[R][C];
        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && map[i][j] != '#') {
                    ts = tw = 0;
                    dfs(i, j);
                    if (ts > tw) sheep += ts;
                    else wolf += tw;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        if (map[r][c] == 'o') ts++;
        else if (map[r][c] == 'v') tw++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (visited[nr][nc]) continue;
            if (map[nr][nc] == '#') continue;

            dfs(nr,nc);
        }
    }
}

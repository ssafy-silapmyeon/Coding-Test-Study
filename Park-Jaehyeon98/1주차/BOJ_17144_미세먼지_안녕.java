import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ_17144_미세먼지_안녕 {
    static int r, c, t, clean_r;
    static int[][] map;

    // 1. 미세먼지가 5미만일 때는 확산 안함
    // 2. 먼지 확산은 모든칸이 동시에 일어나는거 고려
    // 3. 새로운 배열을 만들어서 확산된 먼지부터 넣고 원래 먼지에서 확산된 먼지 값을 뺀거를 넣는다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    clean_r = i;
                }
            }
        }

        for (int k = 0; k < t; k++) {
            diffusion();

        }

        System.out.println(mapSum());

    }

    private static void diffusion() {
        int[][] map2 = new int[r][c];
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    int cnt = 4;
                    int tmp = map[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                            cnt--;
                            continue;
                        }

                        if ((nx == clean_r && ny == 0) || (nx == clean_r - 1 && ny == 0)) {
                            cnt--;
                            continue;
                        }
                        map2[nx][ny] += tmp;
                    }
                    map2[i][j] += map[i][j] - (tmp * cnt);
                }
            }
        }
        rotate(map2);
    }

    // 배열 돌리기
    private static void rotate(int[][] map2) {
        // 청소기 바로 위쪽부터 인덱스부터 배열 돌리기

        // 청소기 위쪽의 왼쪽 돌리기
        for (int i = clean_r - 2; i > 0; i--) {
            map2[i][0] = map2[i-1][0];
        }

        // 청소기 위쪽의 위쪽 돌리기
        for (int i = 1; i < c; i++) {
            map2[0][i - 1] = map2[0][i];
        }

        // 청소기 위쪽의 오른쪽 돌리기
        for (int i = 0; i < clean_r - 1; i++) {
            map2[i][c - 1] = map2[i + 1][c - 1];
        }

        // 청소기 위쪽의 앞쪽 돌리기
        for (int i = c - 1; i > 0; i--) {
            map2[clean_r - 1][i] = map2[clean_r - 1][i - 1];
        }

        // 청소기 아래쪽의 왼쪽 돌리기
        for (int i = clean_r + 1; i < r - 1; i++) {
            map2[i][0] = map2[i + 1][0];
        }

        // 청소기 아래쪽의 아래쪽 돌리기
        for (int i = 1; i < c; i++) {
            map2[r - 1][i - 1] = map2[r - 1][i];
        }

        // 청소기 아래쪽의 오른쪽 돌리기
        for (int i = r - 1; i > clean_r; i--) {
            map2[i][c - 1] = map2[i - 1][c - 1];
        }

        // 청소기 아래쪽의 앞쪽 돌리기
        for (int i = c - 1; i > 0; i--) {
            map2[clean_r][i] = map2[clean_r][i - 1];
        }

        diffustionClean(map2);

        map = map2;
        return;
    }

    private static void diffustionClean(int[][] map2) {
        map2[clean_r - 1][0] = 0;
        map2[clean_r][0] = 0;
    }

    private static int mapSum() {
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                cnt += map[i][j];
            }
        }

        return cnt;
    }

}
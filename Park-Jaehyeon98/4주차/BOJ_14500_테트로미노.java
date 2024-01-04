import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        // 입력
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색 (dfs)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count) {

        // 테트로미노 완성 시 수들의 합 계산
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        for(int i = 0; i < 4; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            // 범위 벗어나면 예외 처리
            if(curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                continue;
            }

            // 아직 방문하지 않은 곳이라면
            if(!visit[curRow][curCol]) {

                // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
                if(count == 2) {
                    visit[curRow][curCol] = true;
                    solve(row, col, sum + arr[curRow][curCol], count + 1);
                    visit[curRow][curCol] = false;
                }

                visit[curRow][curCol] = true;
                solve(curRow, curCol, sum + arr[curRow][curCol], count + 1);
                visit[curRow][curCol] = false;
            }
        }
    }
}

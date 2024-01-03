import java.util.*;

public class BOJ_1987_알파벳 {
    static int r, c;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;
    static boolean[] alpha;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        r = scan.nextInt();
        c = scan.nextInt();
        scan.nextLine();

        board = new int[r][c];
        for(int i = 0; i < r; i++) {
            String str = scan.nextLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        alpha = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int len) {
        alpha[board[x][y]] = true;
        max = Math.max(max, len);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {
                if(!alpha[board[nx][ny]]) {
                    dfs(nx, ny, len + 1);
                    alpha[board[nx][ny]] = false;
                }
            }
        }
    }
}


import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[][] garage;
    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        garage = new int[2 * N][N];
        int[][] board = new int[N][N];
        for (int i = 1; i <= 3 * N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (i <= 2 * N) {
                    garage[2 * N - i][j] = Integer.parseInt(st.nextToken());
                } else {
                    board[3 * N - i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        boolean[][] used = new boolean[2 * N][N];
        answer = 0;
        game(1, 0, board, used);

        System.out.println(answer);
    }

    static void game(int round, int score, int[][] board, boolean[][] used) {
        boolean[][] visited = new boolean[N][N];
        int[][] nBoard = new int[N][N];
        boolean[][] nUsed = new boolean[2 * N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    continue;
                }

                boolean hasSameColor = false;
                for (int d = 0; d < 4; d++) {
                    int nexti = i + di[d];
                    int nextj = j + dj[d];

                    if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N 
                       && !visited[nexti][nextj] && board[i][j] == board[nexti][nextj]) {
                        hasSameColor = true;
                        break;
                    }
                }
                
                int plus;
                copyBoard(board, nBoard);
                if (!hasSameColor) {
                    visited[i][j] = true; 
                    nBoard[i][j] = 0;
                    plus = 2;
                } else {
                    plus = selectBlock(i, j, nBoard, visited);
                }

                if (round < 3) { // 점수 획득 & 빈칸 채우기 
                    removeAndFill(nBoard, used, nUsed);    
                    game(round + 1, score + plus, nBoard, nUsed);
                } else {
                    answer = Math.max(answer, score + plus);
                }
            }
        }
    }

    static void copyBoard(int[][] original, int[][] copy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = original[i][j];
            }
        }
    }

    static int selectBlock(int si, int sj, int[][] board, boolean[][] visited) {
        visited[si][sj] = true;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(si, sj));

        int count = 0;
        int x1 = N;
        int y1 = N;
        int x2 = -1;
        int y2 = -1;
        
        int color = board[si][sj];
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            board[now.i][now.j] = 0;
            count++;
            x1 = Math.min(x1, now.j);
            x2 = Math.max(x2, now.j);
            y1 = Math.min(y1, now.i);
            y2 = Math.max(y2, now.i);
            
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N
                   && !visited[nexti][nextj] && board[nexti][nextj] == color) {
                    visited[nexti][nextj] = true;
                    queue.add(new Point(nexti, nextj));
                }
            }
        }

        return count + (x2 - x1 + 1) * (y2 - y1 + 1);
    }

    static void removeAndFill(int[][] board, boolean[][] used, boolean[][] nUsed) {
        for (int i = 0; i < 2 * N; i++) {
            for (int j = 0; j < N; j++) {
                nUsed[i][j] = used[i][j];
            }
        }

        for (int j = 0; j < N; j++) {
            int nowi = 0; // 현재 채울 열
            for (int i = 0; i < N; i++) {
                if (board[i][j] != 0) {
                    board[nowi][j] = board[i][j];
                    nowi++;
                }
            }

            int outIdx = 0; // 차를 꺼내올 열 
            while (nowi < N) {          
                while (nUsed[outIdx][j]) {   
                    outIdx++;
                }
                board[nowi][j] = garage[outIdx][j];
                nUsed[outIdx][j] = true;
                nowi++;
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

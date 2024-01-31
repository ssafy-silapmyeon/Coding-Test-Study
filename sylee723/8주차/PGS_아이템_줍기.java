import java.util.*;

class Solution {
    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] board = new boolean[102][102];
        for (int r = 0; r < rectangle.length; r++) {
            for (int i = 2 * rectangle[r][0]; i <= 2 * rectangle[r][2]; i++) {
                for (int j = 2 * rectangle[r][1]; j <= 2 * rectangle[r][3]; j++) {
                    board[i][j] = true;
                }
            }
        }
        
        for (int r = 0; r < rectangle.length; r++) {
            for (int i = 2 * rectangle[r][0] + 1; i < 2 * rectangle[r][2]; i++) {
                for (int j = 2 * rectangle[r][1] + 1; j < 2 * rectangle[r][3]; j++) {
                    board[i][j] = false;
                }
            }
        }
        
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         if ((i == characterX * 2 && j == characterY * 2) 
        //             || (i == itemX * 2 && j == itemY * 2)) {
        //             System.out.print("@");
        //         } else {
        //             System.out.print(board[i][j]? "#" : " ");
        //         } 
        //     }
        //     System.out.println();
        // }
        
        int answer = bfs(board, 2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY);
        answer /= 2;
        
        return answer;
    }
    
    static int bfs(boolean[][] board, int cX, int cY, int iX, int iY) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        queue.add(new Point(cX, cY));
        visited[cX][cY] = true;
        
        int distance = 0;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if (now.i == iX && now.j == iY) {
                    return distance;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    
                    if (!visited[nexti][nextj] && board[nexti][nextj]) {
                        queue.add(new Point(nexti, nextj));
                        visited[nexti][nextj] = true;
                    }
                }
            }
            distance++;
        }
        
        return -1;
    }
    
    static class Point {
        int i, j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
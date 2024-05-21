import java.util.*;

class Solution {
    static int M, N;
    static boolean[][] visited;
    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        M = m;
        N = n;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int count = bfs(i, j, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static int bfs(int si, int sj, int[][] picture) {
        int color = picture[si][sj];
        
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(si, sj));
        visited[si][sj] = true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            count++;
            
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];
                
                if (nexti < 0 || nexti >= M || nextj < 0 || nextj >= N) {
                    continue;
                }
                
                if (!visited[nexti][nextj] && picture[nexti][nextj] == color) {
                    visited[nexti][nextj] = true;
                    queue.add(new Point(nexti, nextj));
                }
            }
        }
        
        return count;
    }
    
    static class Point {
        int i, j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
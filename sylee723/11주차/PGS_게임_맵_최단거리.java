import java.util.*;

class Solution {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        queue.add(new Point(0, 0));
        visit[0][0] = true;
        
        int dist = 1;
        int n = maps.length;
        int m = maps[0].length;
        
        int answer = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if (now.i == n-1 && now.j == m-1) {
                    answer = dist;
                    break;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    
                    if (nexti < 0 || nexti >= n || nextj < 0 || nextj >= m)
                        continue;
                    
                    if (!visit[nexti][nextj] && maps[nexti][nextj] == 1) {
                        queue.add(new Point(nexti, nextj));
                        visit[nexti][nextj] = true;
                    }
                }
            }
            dist++;
        }
          
        return answer;
    }
    
    static class Point {
        int i, j;
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
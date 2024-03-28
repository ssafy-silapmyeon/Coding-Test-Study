import java.util.*;

class Solution {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int si = 0;
        int sj = 0;
        int li = 0;
        int lj = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    si = i;
                    sj = j;
                } else if (maps[i].charAt(j) == 'L') {
                    li = i;
                    lj = j;
                }
            }
        }
        
        int d1 = BFS(maps, si, sj, 'L');
        int d2 = BFS(maps, li, lj, 'E');
        
        int answer = -1;
        if (d1 != -1 && d2 != -1) {
            answer = d1 + d2;
        }
        
        return answer;
    }
    
    static int BFS(String[] map, int r, int c, char finish) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length()];
        
        visited[r][c] = true;
        queue.add(new Point(r, c));
        
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if (map[now.i].charAt(now.j) == finish) {
                    return distance;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    
                    if (nexti >= 0 && nexti < map.length && nextj >= 0 && nextj < map[0].length() && ! visited[nexti][nextj] && map[nexti].charAt(nextj) != 'X') {
                        visited[nexti][nextj] = true;
                        queue.add(new Point(nexti, nextj));
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
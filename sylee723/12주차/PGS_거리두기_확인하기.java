import java.util.*;

class Solution {
    static char[][] room = new char[5][];
    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int p = 0; p < places.length; p++) {
            for (int i = 0; i < 5; i++) {
                room[i] = places[p][i].toCharArray();
            }
            
            answer[p] = 1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (room[i][j] == 'P' && !checkDistance(i, j)) {
                        answer[p] = 0;
                        break;
                    }
                }
                if (answer[p] == 0)
                    break;
            }
        }

        return answer;
    }
    
    static boolean checkDistance(int si, int sj) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        visited[si][sj] = true;
        queue.add(new Point(si, sj));
        
        int distance = 0;
        while (!queue.isEmpty() && distance <= 2) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Point now = queue.poll();
                if (room[now.i][now.j] == 'P' && !(now.i == si && now.j == sj)) {
                    return false;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    
                    if (nexti < 0 || nexti >= 5 || nextj < 0 || nextj >= 5) {
                        continue;
                    }
                
                    if (!visited[nexti][nextj] && room[nexti][nextj] != 'X') {
                        visited[nexti][nextj] = true;
                        queue.add(new Point(nexti, nextj));
                    }
                }
            }
            distance++;
        }
        
        return true;
    }
    
    static class Point {
        int i, j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
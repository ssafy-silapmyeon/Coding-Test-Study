import java.util.*;

class Solution {
    static int[][] landNum;
    static Map<Integer, Integer> numCnt;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        landNum = new int[land.length][land[0].length];
        numCnt = new HashMap<>();
        
        int num = 1;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int count = bfs(land, num, i, j);
                    numCnt.put(num, count);
                    num++;
                }
            }
        }
        
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for (int j = 0; j < land[0].length; j++) {
            set.clear();
            
            for (int i = 0; i < land.length; i++) {
                if (landNum[i][j] != 0) {
                    set.add(landNum[i][j]);
                }
            }
            
            int total = 0;
            for (int lNum : set) {
                total += numCnt.get(lNum);
            }
            
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
    
    static int bfs(int[][] land, int num, int si, int sj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(si, sj));
        land[si][sj] = 0;
        
        int count = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            landNum[now.i][now.j] = num;
            count++;
            
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];
                
                if (nexti >= 0 && nexti < land.length && nextj >= 0 && nextj < land[0].length && land[nexti][nextj] == 1) {
                    land[nexti][nextj] = 0;
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
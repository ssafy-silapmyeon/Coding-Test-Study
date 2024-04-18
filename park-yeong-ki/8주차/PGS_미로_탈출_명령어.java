import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[] cArr = {'u', 'd', 'l', 'r'};
    static class Point implements Comparable<Point>{
        String str;
        int r, c, k;
        
        Point(String str, int r, int c, int k){
            this.str = str;
            this.r = r;
            this.c = c;
            this.k = k;
        }
        
        @Override
        public int compareTo(Point o){
            return str.compareTo(o.str);
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        return dijkstra(n, m, x-1, y-1, r-1, c-1, k);
    }
    
    static String dijkstra(int n, int m, int x, int y, int r, int c, int k){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[n][m][k+1];
        
        Point start = new Point("", x, y, 0);
        visited[start.r][start.c][start.k] = true;
        pq.add(start);
        
        Point current;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            current = pq.poll();
            
            if(current.r == r && current.c == c && current.k == k){
                return current.str;
            }
            
            for(int i=0; i<4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                int nk = current.k + 1;
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || nk > k) continue;
                if(visited[nr][nc][nk]) continue;
                sb.append(current.str).append(cArr[i]);
                pq.add(new Point(sb.toString(), nr, nc, nk));
                sb.setLength(0);
                visited[nr][nc][nk] = true;
            }
        }
        
        return "impossible";
    }
}

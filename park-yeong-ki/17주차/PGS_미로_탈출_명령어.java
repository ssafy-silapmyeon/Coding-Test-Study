import java.util.*;

class Solution {
    static class Point{
        int r, c;
        String path;
        
        Point(int r, int c, String path){
            this.r = r;
            this.c = c;
            this.path = path;
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Point start = new Point(x, y, "");
        
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        String[] sArr = {"d", "l", "r", "u"};
        
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[n+1][m+1][k+1];
        
        queue.add(start);
        
        Point current;
        int dist = 0;
        int size;
        while(!queue.isEmpty()){
            size = queue.size();
            
            for(int i=0; i<size; i++){
                current = queue.poll();
                
                if(current.r == r && current.c == c && dist == k){
                    return current.path;
                }
                
                if(dist == k) continue;
                for(int j=0; j<4; j++){
                    int nr = current.r+dr[j];
                    int nc = current.c+dc[j];
                    
                    
                    if(nr < 1 || nr > n || nc < 1 || nc > m) continue;
                    if(visited[nr][nc][dist+1]) continue;
                    
                    queue.add(new Point(nr, nc, current.path + sArr[j]));
                    visited[nr][nc][dist+1] = true;
                }
            }
            
            dist++;
        }
        
        return "impossible";
    }
}

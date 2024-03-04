import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Point{
        int r, c;
        
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] ans = new int[places.length];
       
        boolean flag;
        for(int i=0; i<places.length; i++){
            flag = true;
            
            outer:
            for(int j=0; j<places[i].length; j++){
                for(int k=0; k<places[i][j].length(); k++){
                    if(places[i][j].charAt(k) == 'P'){
                        if(!bfs(new Point(j, k), places[i])){
                            flag = false;
                            break outer;    
                        }
                    }
                }
            }
            
            ans[i] = flag ? 1 : 0;
        }
        
        return ans;
    }
    
    static boolean bfs(Point start, String[] map){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.add(start);
        visited[start.r][start.c] = true;
        
        Point current;
        int size;
        int dist = 0;
        while(!queue.isEmpty() && dist <= 2){
            size = queue.size();
            for(int i=0; i<size; i++){
                current = queue.poll();
                
                if(dist > 0 && map[current.r].charAt(current.c) == 'P'){
                    return false;
                }
                
                for(int j=0; j<4; j++){
                    int nr = current.r + dr[j];
                    int nc = current.c + dc[j];
                    
                    if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                    if(map[nr].charAt(nc) == 'X') continue;
                    if(visited[nr][nc]) continue;
                    
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            
            dist++;
        }
        
        return true;
    }
}

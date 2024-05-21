import java.util.*;

class Solution {
    static class Point{
        int r,c;
        
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new ArrayDeque<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] == 0 || visited[i][j]) continue;
                
                queue.add(new Point(i,j));
                visited[i][j] = true;
                
                int cnt = 0;
                Point cur;
                while(!queue.isEmpty()){
                    cur = queue.poll();
                    cnt++;
                    
                    for(int k=0; k<4; k++){
                        int nr = cur.r + dr[k];
                        int nc = cur.c + dc[k];
                        
                        if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                        if(visited[nr][nc]) continue;
                        if(picture[i][j] != picture[nr][nc]) continue;
                        
                        queue.add(new Point(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
                
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

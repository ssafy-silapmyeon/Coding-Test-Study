import java.util.*;

class Solution {
    int R, C, ans;
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    boolean[] isSelected;
    int[][] map;
    Set<Integer> cards;
    public int solution(int[][] board, int r, int c) {
        R = C = 4;
        map = board;
        cards = new LinkedHashSet<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i][j] != 0){
                    cards.add(board[i][j]);
                }
            }
        }
        
        isSelected = new boolean[7];
        isSelected[0] = true;
        ans = Integer.MAX_VALUE;
        perm(0, r, c, 0);
        
        return ans;
    }
    
    void perm(int idx, int r, int c, int cnt){
        if(ans <= cnt) return;
        
        if(idx == cards.size()){
            ans = cnt;
            return;
        }
        
        for(int num : cards){
            if(isSelected[num]) continue;
            Point first = findCard(num, new Point(r, c, 0), false);
            Point second = findCard(num, new Point(first.r, first.c, first.cnt), true);
            isSelected[num] = true;
            perm(idx+1, second.r, second.c, cnt + second.cnt);
            isSelected[num] = false;
        }
    }
    
    Point findCard(int num, Point pos, boolean pair){
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(pos);
        visited[pos.r][pos.c] = true;
        
        Point cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            
            if((map[cur.r][cur.c] == num) && 
               (!pair || pair && cur.cnt != pos.cnt)){
                cur.cnt++;
                return cur;
            }
            
            for(int i=0; i<8; i++){
                int nr = cur.r+dr[i%4];
                int nc = cur.c+dc[i%4];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                
                if(i >= 4){ 
                    while(true){
                        if(!isSelected[map[nr][nc]]){
                            break;
                        }
                        
                        nr += dr[i%4];
                        nc += dc[i%4];
                        if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                            nr -= dr[i%4];
                            nc -= dc[i%4];
                            break;
                        }
                    }       
                }
                
                if(visited[nr][nc]) continue;
                queue.add(new Point(nr, nc, cur.cnt+1));
                visited[nr][nc] = true;
            }
        }
        
        return null;
    }
    
    class Point{
        int r, c, cnt;
        
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

import java.util.*;

class Solution {
    static int[] dr = {-1,1,0,0}; //상하좌우
    static int[] dc = {0,0,-1,1};
    static class Point implements Comparable<Point>{
        int r, c, d, w;
        Point(int r, int c, int d, int w){
            this.r = r;
            this.c = c;
            this.d = d;
            this.w = w;
        }
        
        @Override
        public int compareTo(Point o){
            return Integer.compare(this.w, o.w);
        }
    }
    
    public int solution(int[][] board) {        
        return dijkstra(board);
    }
    
    static int dijkstra(int[][] board){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 1, 0));
        pq.add(new Point(0, 0, 3, 0));
        
        int N = board.length;
        boolean[][][] visited = new boolean[N][N][4];
        
        Point current;
        while(!pq.isEmpty()){
            current = pq.poll();
            
            if(current.r == N-1 && current.c == N-1){
                return current.w;
            }
            
            if(visited[current.r][current.c][current.d]) continue;
            visited[current.r][current.c][current.d] = true;
            
            for(int i=0; i<4; i++){
                int tr = current.r + dr[i];
                int tc = current.c + dc[i];
                
                if(tr < 0 || tr >= N || tc < 0 || tc >= N) continue;
                if(visited[tr][tc][i]) continue;
                if(board[tr][tc] == 1) continue;
                
                pq.add(new Point(tr, tc, i, current.w + (i != current.d ? 600 : 100)));
            }
        }
        
        return 0;
    }
}

import java.util.*;
class Solution {
    static int answer=0;
    static int sr=0;
    static int sc=0;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    
    static class IDX{
        int i,j;
        IDX(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int solution(int[][] board, int r, int c) {
        answer = Integer.MAX_VALUE;
        boolean[] card = new boolean[7]; //카드는 1~6까지
        int cNum=0;//카드 개수
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j] !=0){
                    card[board[i][j]] = true;
                    cNum++;
                }
            }
        }
        cNum /=2; //카드 개수
        perm(board,card, new boolean[7], new int[cNum],0,r,c);
        
        return answer;
    }
     public int bfs(int[][] board, int c,boolean b){
         int cnt =0;
         boolean[][] visited = new boolean[4][4];
         
         //bfs
         Queue<IDX> queue = new LinkedList<>();
         queue.offer(new IDX(sr,sc));
         visited[sr][sc] = true;
        
         while(!queue.isEmpty()){
             int n = queue.size();
             
             for(int q=0;q<n;q++){
                 IDX cur = queue.poll();
                 int i = cur.i;
                 int j = cur.j;
                 
                 if(board[i][j] == c){
                     if(!(sr ==i && sc ==j && b)){
                         sr = i;
                         sc = j;
                         board[i][j] =0;
                         return cnt+1;
                     }
                 }
             
                 for(int d=0;d<4;d++){
                     if(i+di[d]>=0 && i+di[d]<4 && j+dj[d]>=0 && j+dj[d]<4 && !visited[i+di[d]][j+dj[d]]){
                         queue.offer(new IDX(i+di[d],j+dj[d]));
                         visited[i+di[d]][j+dj[d]] = true;
                     }
                
                     int nr = i;
                     int nc = j;
                     while((nr+di[d]>=0 && nr+di[d]<4 && nc+dj[d]>=0 && nc+dj[d] <4)){
                         nr += di[d];
                         nc += dj[d];
                         if(board[nr][nc] !=0){
                             break;
                         }
                     }
                     if(!visited[nr][nc]){
                         queue.offer(new IDX(nr,nc));
                         visited[nr][nc] = true;
                     }  
                 } 
             }
             cnt ++;
         }
         
        return cnt+1;
    }
    
    
    public void findCard(int[][] board, int[] permCard){
        int count =0;
        
        for(int i=0;i<permCard.length;i++){//해당 카드 찾기 
            count += bfs(board, permCard[i],false);
            count += bfs(board,permCard[i],true);
        }
        System.out.println();
        answer = Math.min(answer, count);
        
    }
    
    public void perm(int[][] board,boolean[] card, boolean[] visited, int[] permCard,int idx,int r,int c){
        if(idx == permCard.length){
            //커서 위치
            sr=r;
            sc=c;
            int[][] copy=new int[4][4];
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    copy[i][j] = board[i][j];
                }
            }
            findCard(copy,permCard);
            return;
        }
        
        for(int i=1;i<=6;i++){
            if(card[i] && !visited[i]){
                visited[i] = true;
                permCard[idx] = i;
                perm(board,card,visited,permCard,idx+1,r,c);
                visited[i] = false;
                
            }
        }
    }
}
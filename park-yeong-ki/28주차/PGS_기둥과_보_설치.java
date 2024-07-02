import java.util.*;

class Solution {
    boolean[][] poll, board;
    int N;
    
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        poll = new boolean[n+1][n+1];
        board = new boolean[n+1][n+1];
        
        int x, y, a;
        boolean b;
        for(int[] bf : build_frame){
            x = bf[0];
            y = n - bf[1];
            a = bf[2];
            b = bf[3] == 0 ? false : true;
            
            if(a == 0){ //기둥
                poll[y][x] = b;
                if(!isPossible()) 
                    poll[y][x] = !b;
            }else{ //보
                board[y][x] = b;
                if(!isPossible()) 
                    board[y][x] = !b;
            }
        }
        
        int[][] answer = findPollAndBoard();
        return answer;
    }
    
    int[][] findPollAndBoard(){
        List<int[]> list = new ArrayList<>();
        for(int c=0; c<=N; c++){
            for(int r=N; r>=0; r--){
                if(poll[r][c]){
                    list.add(new int[]{c, N-r, 0});
                }
                if(board[r][c]){
                    list.add(new int[]{c, N-r, 1});
                }
            }
        }
        
        int[][] arr = new int[list.size()][3];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        
        return arr;
    }
    
    boolean isPossible(){
        for(int c=0; c<=N; c++){
            for(int r=N; r>=0; r--){
                
                if(poll[r][c]){
                    if(!(r == N || board[r][c] || (c != 0 && board[r][c-1])|| poll[r+1][c])){
                        return false;
                    }
                }
                
                if(board[r][c]){
                    if(!(poll[r+1][c] || poll[r+1][c+1] || 
                         (1<=c && c<N-1 && board[r][c-1] && board[r][c+1]))){
                        return false;
                    }
                }
                
            }
        }
        
        return true;
    }
}

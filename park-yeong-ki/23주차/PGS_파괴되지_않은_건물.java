class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] pMap = new int[N+1][M+1];
        int t,r1,c1,r2,c2,d;
        for(int[] s : skill){
            t = s[0] == 1 ? -1 : 1;
            r1 = s[1];
            c1 = s[2];
            r2 = s[3];
            c2 = s[4];
            d = s[5] * t;
            
            pMap[r1][c1] += d;
            pMap[r2+1][c2+1] += d;
            pMap[r1][c2+1] -= d;
            pMap[r2+1][c1] -= d;
        }
        
        for(int i=0; i<M; i++){
            for(int j=1; j<N; j++){
                pMap[j][i] += pMap[j-1][i];
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=1; j<M; j++){
                pMap[i][j] += pMap[i][j-1];
            }
        }
        
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] += pMap[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        
        return answer;
    }
}

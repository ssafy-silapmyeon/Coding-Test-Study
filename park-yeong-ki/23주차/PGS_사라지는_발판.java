class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int R, C;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        R = board.length;
        C = board[0].length;
        
        int answer = dfs(board, aloc[0], aloc[1], bloc[0], bloc[1]);
        return answer;
    }
    
    static int dfs(int[][] board, int cr, int cc, int or, int oc){
        if(board[cr][cc] == 0) return 0;
        
        int cnt = 0;
        for(int i=0; i<4; i++){
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(board[nr][nc] == 0) continue;
            
            board[cr][cc] = 0;
            int nCnt = dfs(board, or, oc, nr, nc) + 1; //상대방 움직이는 경우의 수에서 현재 플레이어가 이동한 1만큼 더함
            board[cr][cc] = 1;
            
            if(cnt % 2 == 0 && nCnt % 2 == 1){ //지는 상태에서 이기는 경우 발견 -> 승리하는 방향이 최적의 플레이
                cnt = nCnt;
            } else if(cnt % 2 == 0 && nCnt % 2 == 0){ //지는 상태에서 지는 경우 발견 -> 가장 늦게 지는 경우가 최적의 플레이
                cnt = Math.max(cnt, nCnt);
            } else if(cnt % 2 == 1 && nCnt % 2 == 1){ //이기는 상태에서 이기는 경우 발견 -> 가장 빨리 이기는 경우가 최적의 플레이
                cnt = Math.min(cnt, nCnt);
            }
        }
        
        return cnt;
    }
}

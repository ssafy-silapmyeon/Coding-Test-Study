class Solution {
    static int N, M;
    static boolean[][] block;
    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        block = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    block[i][j] = true;
                }
            }
        }
        
        return game(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
    
    static int game(int nowi, int nowj, int opi, int opj) {
        if (!block[nowi][nowj]) {
            return 0;
        }
        
        int ret = 0;
        block[nowi][nowj] = false;
        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];
            
            if (nexti < 0 || nexti >= N || nextj < 0 || nextj >= M 
                || !block[nexti][nextj]) {
                continue;
            }
            
            int count = game(opi, opj, nexti, nextj) + 1;
            // count가 홀수이면 현재 플레이어가 이김
            
            if (ret % 2 == 0) {
                if (count % 2 != 0) {
                    ret = count;
                } else {
                    ret = Math.max(ret, count);
                }
            } else if (count % 2 != 0) {
                ret = Math.min(ret, count);
            }
        }
        block[nowi][nowj] = true;
        
        return ret;
    }
}
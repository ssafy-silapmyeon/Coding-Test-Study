class Solution {
    static int N, M;
    static int[][] LOCK;
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        
        LOCK = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                LOCK[i][j] = lock[i][j];
            }
        }
        
        for (int r = 0; r < 4; r++) {
            if (unlock(key)) {
                return true;
            }
            if (r == 3) {
                break;
            }
            key = rotate(key);
        }
       
        return false;
    }
    
    static int[][] rotate(int[][] key) {
        // 오른쪽으로 회전
        int[][] rKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rKey[i][j] = key[M - 1 - j][i];
            }
        }
        
        return rKey;
    }
    
    static boolean unlock(int[][] key) {
        for (int i = -M + 1; i < N; i++) {
            for (int j = -M + 1; j < N; j++) {
                if (isAvailable(i, j, key)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    static boolean isAvailable(int si, int sj, int[][] key) {
        int[][] nowKey = new int[N][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (i + si >= 0 && i + si < N && j + sj >= 0 && j + sj < N) {
                    nowKey[i + si][j + sj] = key[i][j];
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (LOCK[i][j] == nowKey[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
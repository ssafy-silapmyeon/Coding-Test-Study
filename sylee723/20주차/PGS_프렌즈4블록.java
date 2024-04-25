class Solution {
    static char[][] b;
    static int r, c;
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        b = new char[m][n];
        r = m;
        c = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = board[i].charAt(j);
            }
        }
        
        while (true) {
            int count = eraseBlock();
            if (count == 0) {
                break;
            }

            answer += count;
        }
        
        return answer;
    }
    
    static int eraseBlock() {
        boolean[][] erase = new boolean[r][c];
        char[][] erasedBoard = new char[r][c];
        
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                if (b[i][j] != '.'
                    && b[i][j] == b[i][j + 1]
                    && b[i][j + 1] == b[i + 1][j]
                    && b[i + 1][j] == b[i + 1][j + 1]) {
                    erase[i][j] = true;
                    erase[i][j + 1] = true;
                    erase[i + 1][j] = true;
                    erase[i + 1][j + 1] = true;
                }
            }
        }
        
        int count = 0;
        for (int j = 0; j < c; j++) {
            int idx = r - 1;
            for (int i = r - 1; i >= 0; i--) {
                if (!erase[i][j]) {
                    erasedBoard[idx][j] = b[i][j];
                    idx--;
                } else {
                    count++;
                }
            }
            
            // 빈칸으로 채우기
            for (int i = idx; i >= 0; i--) {
                erasedBoard[i][j] = '.';
            }
        }
        
        b = erasedBoard;
        return count;
    }
}
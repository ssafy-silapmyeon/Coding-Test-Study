class Solution
{
    public int solution(int [][]board)
    {
        int[][] sum = new int[board.length][board[0].length];
        sum[0][0] = board[0][0];
        for (int j = 1; j < board[0].length; j++) {
            sum[0][j] = sum[0][j - 1] + board[0][j];
        }
        for (int i = 1; i < board.length; i++) {
            sum[i][0] = sum[i - 1][0] + board[i][0];
        }
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + board[i][j] - sum[i - 1][j - 1];
            }
        }
        
        
        int len = Math.min(board.length, board[0].length);
        while (len > 0) { 
            boolean find = false;
            for (int ei = len - 1; ei < board.length; ei++) {
                for (int ej = len - 1; ej < board[0].length; ej++) {
                    int x = ei - len;
                    int y = ej - len;
                    
                    int s1 = sum[ei][ej];
                    int s2 = (x >= 0) ? sum[x][ej] : 0;
                    int s3 = (y >= 0) ? sum[ei][y] : 0;
                    int s4 = (x >= 0 && y >= 0)? sum[x][y] : 0;

                    if (s1 - s2 - s3 + s4 == len * len) {
                        return len * len;
                    }
                }
            }
            
            len--;
        }

        return len;
    }
}
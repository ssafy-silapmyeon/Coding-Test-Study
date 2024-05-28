class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] change = new int[board.length + 1][board[0].length + 1];
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];
            
            if (type == 1) {
                degree *= (-1);
            }
            
            change[r1][c1] += degree;
            change[r1][c2 + 1] -= degree;
            change[r2 + 1][c1] -= degree;
            change[r2 + 1][c2 + 1] += degree;
        }
        
        // 왼쪽에서 오른쪽으로 누적합
        for (int i = 0; i < change.length; i++) {
            for (int j = 1; j < change[0].length; j++) {
                change[i][j] += change[i][j - 1];
            }
        }
        
        // 위에서 아래로 누적합
        for (int j = 0; j < change[0].length; j++) {
            for (int i = 1; i < change.length; i++) {
                change[i][j] += change[i - 1][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + change[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
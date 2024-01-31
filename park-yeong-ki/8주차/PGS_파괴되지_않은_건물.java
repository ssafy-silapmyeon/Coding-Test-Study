class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefix = new int[board.length+1][board[0].length+1];
        int r1, c1, r2, c2, degree;
        for(int i=0; i<skill.length; i++){
            degree = skill[i][5];
            if(skill[i][0] == 1) degree *= -1;
            
            r1 = skill[i][1];
            c1 = skill[i][2];
            r2 = skill[i][3];
            c2 = skill[i][4];
            
            prefix[r1][c1] += degree;
            prefix[r2+1][c2+1] += degree;
            prefix[r1][c2+1] += -1 * degree;
            prefix[r2+1][c1] += -1 * degree;
        }
        
        for(int i=0; i<prefix[0].length; i++){
            for(int j=1; j<prefix.length; j++){
                prefix[j][i] += prefix[j-1][i];
            }
        }
        
        for(int i=0; i<prefix.length; i++){
            for(int j=1; j<prefix[0].length; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }
        
        int ans = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] + prefix[i][j] > 0) ans++;
            }
        }
        
        return ans;
    }
}

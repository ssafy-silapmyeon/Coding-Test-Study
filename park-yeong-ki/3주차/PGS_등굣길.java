class PGS_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int col = m;
        int row = n;

        int[][] dp = new int[row+1][col+1];
        dp[1][1] = 1;

        boolean[][] water = new boolean[row+1][col+1];
        for(int i=0; i<puddles.length; i++){
            int r = puddles[i][1];
            int c = puddles[i][0];
            water[r][c] = true;
        }

        int mod = 1000000007;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                if(dp[i][j] == 0){
                    continue;
                }else{
                    if(i+1 <= row && !water[i+1][j]){
                        dp[i+1][j] += dp[i][j];
                        dp[i+1][j] %= mod;
                    }

                    if(j+1 <= col && !water[i][j+1]){
                        dp[i][j+1] += dp[i][j];
                        dp[i][j+1] %= mod;
                    }
                }
            }
        }

        return dp[row][col];
    }
}
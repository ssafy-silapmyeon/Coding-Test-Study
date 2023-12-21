class PSG_정수_삼각형 {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i+1][j+1] = triangle[i][j];
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans, dp[n][i]);
        }

        return ans;
    }
}
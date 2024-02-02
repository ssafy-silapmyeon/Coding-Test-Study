class Solution {
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length+1][n+1];
        int mod = 1000000007;
        for(int i=1; i<=money.length; i++){
            dp[i][0] = 1;
            for(int j=1; j<=n; j++){
                if(j - money[i-1] < 0) dp[i][j] = dp[i-1][j] % mod;
                else dp[i][j] = (dp[i-1][j] + dp[i][j - money[i-1]]) % mod;
            }
        }
        
        return dp[money.length][n];
    }
}

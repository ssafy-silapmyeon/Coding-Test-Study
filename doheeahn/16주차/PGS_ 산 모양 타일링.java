class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] top = {1,2};
        int[][] dp = new int[n][2];
        
        dp[0][0] = 1; //3번 마름모일때
        dp[0][1] = top[tops[0]]+1; //1,2,4 마름모일때
        
        for(int i=1;i<n;i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]) % 10007;
            dp[i][1] = (dp[i-1][0] * top[tops[i]] + dp[i-1][1] * (top[tops[i]]+1)) % 10007;
        }
        
        answer = (dp[n-1][0]+dp[n-1][1]) % 10007;
        return answer;
    }
}
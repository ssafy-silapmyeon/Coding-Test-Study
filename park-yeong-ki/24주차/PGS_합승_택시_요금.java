class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dp = new int[n+1][n+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                dp[i][j] = INF;
            }
        }
        
        int from, to, cost;
        for(int[] fare : fares){
            from = fare[0];
            to = fare[1];
            cost = fare[2];
            
            dp[from][to] = cost;
            dp[to][from] = cost;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(dp[j][i] == INF || dp[i][k] == INF) continue;
                    dp[j][k] = Math.min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            if(dp[s][i] == INF || dp[i][a] == INF || dp[i][b] == INF) continue;
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        
        return answer;
    }
}

import java.util.*;

class Solution {    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int dist[][] = new int[n+1][n+1];
        int INF = 200 * 100000 + 1;
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }
        
        int from, to, cost;
        for(int i=0; i<fares.length; i++){
            from = fares[i][0];
            to = fares[i][1];
            cost = fares[i][2];
            
            dist[from][to] = cost;
            dist[to][from] = cost;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }        
        
        int ans = INF;
        for(int i=1; i<=n; i++){        
            ans = Math.min(ans, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        
        return ans;
    }   
}

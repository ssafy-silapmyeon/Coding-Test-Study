class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] adjArr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    adjArr[i][j] = 0;
                } else {
                    adjArr[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            adjArr[c][d] = f;
            adjArr[d][c] = f;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= n; j++) {
                    if (i == j || k == j 
                        || adjArr[i][k] == Integer.MAX_VALUE 
                        || adjArr[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    adjArr[i][j] = Math.min(adjArr[i][j], adjArr[i][k] + adjArr[k][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int m = 1; m <= n; m++) {
            if (adjArr[s][m] == Integer.MAX_VALUE || adjArr[m][a] == Integer.MAX_VALUE || adjArr[m][b] == Integer.MAX_VALUE) {
                continue;
            }
            
            answer = Math.min(answer, adjArr[s][m] + adjArr[m][a] + adjArr[m][b]);
        }
        
        return answer;
    }
}
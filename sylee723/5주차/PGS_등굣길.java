class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[n + 1][m + 1];
        boolean[][] pMap = new boolean[n + 1][m + 1];

        for (int p = 0; p < puddles.length; p++) {
            int j = puddles[p][0];
            int i = puddles[p][1];
            
            pMap[i][j] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    d[i][j] = 1;
                    continue;
                }
                
                if (pMap[i][j]) {
                    d[i][j] = 0;
                } else {
                    d[i][j] = d[i - 1][j] + d[i][j - 1];
                    d[i][j] %= 1000000007;
                }
            }
        }
        
        int answer = d[n][m];
        return answer;
    }
}
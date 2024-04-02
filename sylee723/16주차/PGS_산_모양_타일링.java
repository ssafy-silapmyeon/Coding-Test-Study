class Solution {
    public int solution(int n, int[] tops) {
        int[][] d = new int[n + 1][2];
        // d[i][0] : 윗줄
        // d[i][1] : 아랫줄
        d[0][0] = 1; // 없는 칸
        d[0][1] = 1;
        
        for (int i = 1; i <= n; i++) {
            if (tops[i - 1] == 1) {
                d[i][0] = (d[i - 1][1] * 2 + d[i - 1][0]) % 10007;
            } else {
                d[i][0] = (d[i - 1][1] + d[i - 1][0]) % 10007;
            }
            
            d[i][1] = (d[i - 1][1] + d[i][0]) % 10007;
        }
        
        int answer = d[n][1];
        return answer;
    }
}
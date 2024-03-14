class Solution {
    public long solution(int n) {
        long[] memo = new long[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
            memo[i] %= 1234567;
        }
        
        return memo[n];
    }
}
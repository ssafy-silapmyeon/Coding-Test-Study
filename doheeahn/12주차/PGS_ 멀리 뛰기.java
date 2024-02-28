class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2000]; //n으로 배열 크기 만들었을때는
        dp[0] = 1;
        dp[1] = 2;//n=1이라면 여기서 오류 나겠지 이부분 생각못함
        for(int i=2;i<n;i++){
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        
        answer = dp[n-1];
        return answer;
    }
}
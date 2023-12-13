class PSG_3_x_n_타일링 {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        int s = 0;
        int num = 1000000007;
        for(int i=3; i<=n; i++){
            if(i % 2 == 0){ //홀수인 경우만 방법 존재
                s = (int)((s + dp[i-4] * 2L) % num); //세로로 놓여있는 직사각형 하나를 눕히는 경우의 수
                dp[i] = (int)((dp[i-2] * 3L + s) % num);
            }
        }

        return dp[n];
    }
}
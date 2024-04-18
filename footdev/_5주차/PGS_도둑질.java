package footdev._5주차;

import java.util.*;

class PGS_도둑질 {

    int ans;

    public int solution(int[] money) {
        int[] dp = new int[money.length];
        bottomUp(money, dp);
        return ans;
    }

    public void bottomUp(int[] money, int[] dp) {
        dp[0] = money[0];
        dp[1] = dp[0];
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }
        dp[dp.length - 1] = dp[dp.length - 2];

        ans = dp[dp.length - 1];

        dp[0] = 0;
        dp[1] = money[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        ans = Math.max(ans, dp[dp.length - 1]);
    }

    //정확성은 맞지만 효율성에서 StackOverFlowException
    public void topDown(int[] money, int[] dp, int idx) {

        if (idx == money.length){
            ans = Math.max(ans, dp[money.length - 1]);
            return;
        }

        if (idx == 0) {
            dp[0] = money[0];
            topDown(money, dp, idx + 1);
            Arrays.fill(dp, 0);
            topDown(money, dp, idx + 1);
            return;
        }

        if (idx == 1) {
            dp[1] = dp[0] != 0 ? dp[0] : money[1];
            topDown(money, dp, idx + 1);
            return;
        }

        if (idx == money.length - 1) {
            dp[idx] = dp[0] == 0 ? Math.max(dp[idx - 2] + money[idx], dp[idx - 1]) : dp[idx - 1];
            topDown(money, dp, idx + 1);
            return;
        }

        dp[idx] = Math.max(dp[idx - 2] + money[idx], dp[idx - 1]);
        topDown(money, dp, idx + 1);
    }
}
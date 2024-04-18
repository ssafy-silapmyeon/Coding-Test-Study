package footdev._12주차;

import java.util.*;
import java.io.*;

public class BOJ_징검다리_건너기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[][] dp;
    static Jump[] jumps;
    static boolean[] used;

    public static void main(String[] args) throws IOException {

        //초기화
        n = Integer.parseInt(br.readLine());
        jumps = new Jump[n - 1];
        dp = new int[n][2];
        used = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            jumps[i] = new Jump(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        k = Integer.parseInt(br.readLine());

        //로직
        /*
        O --- O --- O --- O --- O

        목표 = 마지막 돌에 착지 했을 때 드는 비용의 최소값 찾기

        - 매우 큰 점프는 딱 한번 사용할 수 있음.

        8
        k = 10
        8 9
        5 7
        5 7
        5 7
        1 10
        1 10
        1 10

        dp[n][0] = 슈점을 사용하지 않은 최소비용
        dp[n][1] = 슈점을 이용하여 구한 최소비용

        dp[n][0] = min dp[i - 1][0] + 작은 점프 비용, dp[i - 2][0] + 큰 점프 비용
        dp[n][1] = min 한번도 슈점 하지 않은 i - 3번 째 최소 비용 + k, 슈점을 사용했는지 안 사용했는지 모를 i - 1번 째 최소비용 + 작은점프비용

        어처피 슈점을 사용했든 안했든
         */
        if (n < 3) {
            System.out.println(n == 1 ? 0 : jumps[0].smallCost);
        } else {
            dp[1][0] = jumps[0].smallCost;
            dp[2][0] = Math.min(dp[1][0] + jumps[1].smallCost, jumps[0].bigCost);
            dp[1][1] = dp[1][0];
            dp[2][1] = dp[2][0];

            for (int i = 3; i < n; i++) {
                int a = dp[i - 1][0] + jumps[i - 1].smallCost;
                int b = dp[i - 2][0] + jumps[i - 2].bigCost;
                int c = dp[i - 3][0] + k;

                dp[i][0] = Math.min(a, b);


                dp[i][1] = Math.min(dp[i - 1][1] + jumps[i - 1].smallCost, dp[i - 2][1] + jumps[i - 2].bigCost);
                dp[i][1] = Math.min(c, dp[i][1]);

            }

            System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
        }
    }

    static class Jump {
        int smallCost;
        int bigCost;

        public Jump(int smallCost, int bigCost) {
            this.smallCost = smallCost;
            this.bigCost = bigCost;
        }
    }
}

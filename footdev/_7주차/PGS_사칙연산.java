package footdev._7주차;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_사칙연산 {

    int n;
    int[][] maxDp, minDp;

    public int solution(String arr[]) {

        n = arr.length;
        maxDp = new int[n][n];
        minDp = new int[n][n];

        //i ~ i에 대해서 dp 채우기
        for (int i = 0; i < n; i += 2) {
            maxDp[i][i] = stoi(arr[i]);
            minDp[i][i] = stoi(arr[i]);
        }

        //x 범위 만큼 연산
        for (int x = 3; x <= n; x += 2) {
            //모든 구간의 dp[l][r]값을 구한다.
            for (int l = 0; l < n; l += 2) {
                int r = l + x - 1;
                //x 범위를 더했을 때 r이 범위를 벗어나는 경우는 break 해준다.
                if (r >= n) break;
                int candidatesMax = Integer.MIN_VALUE, candidatesMin = Integer.MAX_VALUE;
                for (int opr = l + 1; opr < r; opr += 2) {
                    if ("+".equals(arr[opr])) {
                        candidatesMax = Math.max(maxDp[l][opr - 1] + maxDp[opr + 1][r], candidatesMax);
                        candidatesMin = Math.min(minDp[l][opr - 1] + minDp[opr + 1][r], candidatesMin);
                    } else {
                        candidatesMax = Math.max(minDp[l][opr - 1] - minDp[opr + 1][r], candidatesMax);
                        candidatesMin = Math.min(minDp[l][opr - 1] - maxDp[opr + 1][r], candidatesMin);
                    }
                }

                maxDp[l][r] = candidatesMax;
                minDp[l][r] = candidatesMin;
            }
        }

        return maxDp[0][n - 1];
    }

    public int stoi(String s) {
        return Integer.parseInt(s);
    }
}

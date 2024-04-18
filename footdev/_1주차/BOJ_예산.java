package footdev._1주차;

import java.util.*;
import java.io.*;

public class BOJ_예산 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, lo, hi, mid;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        //초기화
        n = Integer.parseInt(br.readLine());
        budgets = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());

        //로직
        Arrays.sort(budgets);
        hi = m + 1;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            int sum = Arrays.stream(budgets)
                    .map(budget -> Math.min(budget, mid))
                    .sum();
            if (sum <= m) {
                //예산이 총액 이하일 때
                lo = mid + 1;
            } else {
                //예산이 총액을 초과했을 때
                hi = mid;
            }
        }

        int sum = Arrays.stream(budgets)
                .sum();
        if (sum <= m) {
            System.out.println(budgets[n - 1]);
        } else {
            System.out.println(lo - 1);
        }
    }
}

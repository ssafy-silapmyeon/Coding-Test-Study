package footdev._3주차;

import java.util.*;
import java.io.*;

public class BOJ_과자_나눠주기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long lo = 1, hi, mid;
    static int[] snacks;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        snacks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        /*
        목표
        - M명의 조카에게 길이가 동일한 막대과자를 제공했을 때 최대 길이값을 구해라.

        조건
        - 모든 조카에게 같은 길이의 막대과자를 나눠야함.
        - n개의 과자에서 m개만큼 동일한 개수로 나눠야함.

        결정 문제
        - mid 길이만큼 빼빼로를 나눴을 때 n개를 만족하는가?
            - n개 보다 못만들었다면 mid를 줄여야 한다.
            - n개 만큼 만들거나 더 만들었을 경우 mid를 늘려야한다.

        탐색 범위
        - 1 ~ 제공된 막대과자 길이 중 가장 긴 값
        */

        Arrays.sort(snacks);
        hi = snacks[n - 1];
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += snacks[i] / mid;
            }
            if (cnt < m) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        //출력
        long sum = Arrays.stream(snacks).sum();
        if (sum < n) {
            System.out.println(0);
        } else {
            System.out.println(lo - 1);
        }
    }
}
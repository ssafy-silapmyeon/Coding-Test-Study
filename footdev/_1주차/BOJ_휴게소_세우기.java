package footdev._1주차;

import java.util.*;
import java.io.*;

public class BOJ_휴게소_세우기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, l, lo = 1, hi, mid;
    static int[] points;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        points = new int[n + 2];
        points[0] = 0;
        points[1] = l;

        if (n > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 2; i < n + 2; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        Arrays.sort(points);
        hi = l;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            int sum = 0;
            for (int i = 1; i < n + 2; i++) {
                sum += (points[i] - points[i - 1] - 1) / mid;
            }
            if (sum > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        //출력
        System.out.println(lo);
    }
}
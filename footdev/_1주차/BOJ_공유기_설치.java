package footdev._1주차;

import java.util.*;
import java.io.*;

public class BOJ_공유기_설치 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, c;
    static int[] points;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        points = new int[n];

        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        //로직
        Arrays.sort(points);
        int l = 0;
        int r = points[n - 1] + 1;
        while (l < r) {
            int m = (l + r) / 2;
            int cnt = 0, from = 0, to = from + 1;
            while (from < n - 1) {

                if (to == n) {
                    break;
                }

                if (points[to] - points[from] >= m) {
                    cnt++;
                    from = to;
                    to = from + 1;
                } else {
                    to++;
                }
            }

            if (cnt >= c - 1) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        System.out.println(l - 1);
    }
}
package footdev._2주차;

import java.util.*;
import java.io.*;

public class BOJ_입국심사 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long lo, hi, mid;
    static int[] times;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }

        //로직
        lo = 0;
        hi = (long) 1e18;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            long cnt = 0L;
            for (int i = 0; i < n; i++) {
                cnt += mid / times[i];
                if (cnt > m) break;
            }
            if (cnt < m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        //출력
        System.out.println(lo);
    }
}
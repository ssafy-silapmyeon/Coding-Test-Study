package footdev._2주차;

import java.io.*;
import java.util.*;

public class BOJ_놀이_공원 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long lo, hi, mid;
    static int[] rides;

    public static void main(String[] args) throws IOException {

        //초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rides = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            rides[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        if (n <= m) {
            System.out.println(n);
        } else {
            hi = (long) (2e9 * 30);
            while (lo <= hi) {
                mid = (lo + hi) / 2;
                long cnt = m;
                for (int i = 0; i < m; i++) {
                    cnt += mid / rides[i];
                }
                if (cnt < n) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            long cnt = getChildNumByTime(lo - 1);
            int ans = 0;
            for (int i = 0; i < m; i++) {
                if (lo % rides[i] == 0) {
                    cnt++;
                    ans = i + 1;
                }
                if (cnt == n) break;
            }

            System.out.println(ans);
        }
    }

    static long getChildNumByTime(long time) {
        return Arrays.stream(rides)
                .mapToLong(i -> time / i)
                .sum() + m;
    }
}

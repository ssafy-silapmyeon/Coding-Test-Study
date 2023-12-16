package footdev._1주차;

import java.util.*;
import java.io.*;

public class BOJ_기타_레슨 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m, lo, hi, mid;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        //초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            hi += lectures[i];
        }

        //로직
        hi++;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            int sum = 0, cnt = 1;
            for (int i = 0; i < n; i++) {
                if (lectures[i] > mid) {
                    cnt = m + 1;
                    break;
                }
                if (sum + lectures[i] <= mid) {
                    sum += lectures[i];
                } else {
                    sum = lectures[i];
                    cnt++;
                }
            }
            if (cnt > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        //출력
        System.out.println(hi);
    }
}

package footdev._1주차;

import java.io.*;

public class BOJ_K번째_수 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, k;
    static long lo, hi, mid;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        lo = 1;
        hi = k;

        while(lo < hi) {
            long mid = (lo + hi) / 2;
            long count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }
            if(k <= count) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}

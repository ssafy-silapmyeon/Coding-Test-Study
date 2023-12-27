package footdev._2주차;

import java.util.*;
import java.io.*;

public class BOJ_용돈_관리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static long lo = 1, hi, mid;
    static int[] prices;
    static List<Long> minArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        //로직
        hi = (long) 1e9;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int cnt = 1;
            long money = mid;
            for (int i = 0; i < n; i++) {
                if (prices[i] > mid) {
                    cnt = Integer.MAX_VALUE;
                    break;
                }
                if (prices[i] > money) {
                    money = mid - prices[i];
                    cnt++;
                } else {
                    money -= prices[i];
                }
            }
            if (cnt <= m) {
                hi = mid - 1;
                if (cnt == m) {
                    minArr.add(mid);
                }
            } else {
                lo = mid + 1;
            }
        }
        Collections.sort(minArr);
        if (minArr.size() == 0) {
            System.out.println(lo);
        } else {
            System.out.println(minArr.get(0));
        }
    }
}

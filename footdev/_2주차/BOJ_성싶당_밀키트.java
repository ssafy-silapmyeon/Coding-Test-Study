package footdev._2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_성싶당_밀키트 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, G, k, oCnt;
    static long lo, hi, x;
    static List<Food> foods;

    public static void main(String[] args) throws IOException {

        //초기화
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        foods = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            if (o == 0) oCnt++;
            foods.add(new Food(s, l, o));
            foods.get(i).setGerm((long) 2e9 / 2);
        }

        //로직
        hi = (long) 2e9;
        while (lo <= hi) {
            x = (lo + hi) / 2;
            long sum = 0;
            int oLocalCnt = k;

            for (Food food : foods) {
                sum += food.setGerm(x);
            }

            Collections.sort(foods);

            int idx = 0;
            while (true) {
                if (foods.get(idx).o == 0 || idx >= k) break;
                sum -= foods.get(idx++).g;
            }
            if (sum <= G) {
                lo = x + 1;
            } else {
                hi = x - 1;
            }
        }

        //출력
        System.out.println(lo - 1);

    }

    static class Food implements Comparable<Food> {
        int s;
        int l;
        int o;
        long g;

        public Food(int s, int l, int o) {
            this.s = s;
            this.l = l;
            this.o = o;
        }

        public long setGerm(long x) {
            return this.g = this.s * Math.max(1, x - this.l);
        }

        @Override
        public int compareTo(Food o) {
            if (this.o > o.o) return -1;
            else if (this.o < o.o) return 1;
            if (this.g > o.g) return -1;
            else if (this.g < o.g) return 1;
            return 0;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "s=" + s +
                    ", l=" + l +
                    ", o=" + o +
                    ", g=" + g +
                    '}';
        }
    }
}

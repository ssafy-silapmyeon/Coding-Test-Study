package footdev._4주차;

import java.util.*;

public class PGS_징검다리_건너기 {
    public long solution(int[] stones, int k) {
        int len = stones.length;
        long lo = 0, hi = (long) 2e9 + 1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (check(mid, k, stones)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo - 1;
    }

    public boolean check(long mid, int k, int[] stones) {
        long cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (cnt >= k) return false;
            if (stones[i] < mid) {
                cnt++;
            } else {
                cnt = 0;
            }
        }
        if (cnt >= k) return false;
        return true;
    }
}
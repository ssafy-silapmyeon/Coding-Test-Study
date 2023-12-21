package footdev._2주차;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ_두_용액 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, mid, lo, hi;
    static long ans;
    static long[] solutions, minSolutions;

    public static void main(String[] args) throws IOException {

        //초기화
        n = Integer.parseInt(br.readLine());
        solutions = new long[n];
        minSolutions = new long[2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        //로직
        Arrays.sort(solutions);
        hi = n - 1;
        ans = Long.MAX_VALUE;
        while (lo < hi) {
            long sum = solutions[lo] + solutions[hi];
            if (Math.abs(sum) < ans) {
                ans = Math.abs(sum);
                minSolutions[0] = solutions[lo];
                minSolutions[1] = solutions[hi];
            }
            if (sum == 0) {
                minSolutions[0] = solutions[lo];
                minSolutions[1] = solutions[hi];
                break;
            } else if (sum < 0) {
                lo++;
            } else {
                hi--;
            }
        }

        //출력
        Arrays.sort(minSolutions);
        System.out.println(minSolutions[0] + " " + minSolutions[1]);
    }
}

package footdev._11주차;

import java.io.*;
import java.util.*;

public class BOJ_가장_긴_증가하는_부분_수열_5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] nums, dp;

    static List<Integer> lis = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        //초기화
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(nums[0]);
        dp[0] = 1;
        //로직
        for (int i = 1; i < n; i++) {
            //n번 째 숫자가 lis의 마지막 숫자보다 클 경우
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
                dp[i] = lis.size();
            } else {
                int idx = binarySearch(nums[i]);
                lis.set(idx, nums[i]);
                dp[i] = idx + 1;
            }
        }

        //LIS 수열을 담기 출력하기 위한 과정
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = dp[i] > dp[max] ? i : max;
        }

        Stack<Integer> s = new Stack<>();
        s.push(nums[max]);
        for (int i = max - 1; i >= 0; i--) {
            if (dp[max] - dp[i] == 1) {
                s.push(nums[i]);
                max = i;
            }
        }


        //출력
        sb.append(lis.size() + "\n");
        while (!s.isEmpty()) {
            sb.append(s.pop() + " ");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int n) {
        int l = 0;
        int r = lis.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (lis.get(mid) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }
}

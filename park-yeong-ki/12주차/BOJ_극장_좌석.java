import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N, M;
    static Integer[][][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 2];
        int num;
        for (int i = 0; i < M; i++) {
            num = sc.nextInt();
            arr[num] = num;
        }
        arr[0] = 0;
        arr[N + 1] = N + 1;

        memo = new Integer[N + 2][N + 2][N + 2];
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < N+2; j++) {
                memo[N + 1][i][j] = 1;
            }
        }

        System.out.println(recursion(1, 0, 0));
    }

    static int recursion(int idx, int prev1, int prev2) {
        if (memo[idx][prev1][prev2] != null) {
            return memo[idx][prev1][prev2];
        }
        memo[idx][prev1][prev2] = 0;

        if (arr[idx] == idx) {
            memo[idx][prev1][prev2] += recursion(idx + 1, idx, prev1);
        } else {
            for (int i = idx - 1; i <= idx + 1; i++) {
                if (i == prev1 || i == prev2 || arr[i] == i) continue;
                memo[idx][prev1][prev2] += recursion(idx + 1, i, prev1);
            }
        }

        memo[idx][prev2][prev1] = memo[idx][prev1][prev2];
        return memo[idx][prev1][prev2];
    }
}

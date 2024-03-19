import java.util.Scanner;

public class Main {
    static int[] memo, child;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        child = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            child[i] = sc.nextInt();
        }
        memo = new int[N + 1];

        System.out.println(N - (recursion(0) - 1));
    }

    static int recursion(int idx) {
        if (memo[idx] != 0) {
            return memo[idx];
        }
        memo[idx] = 1;

        for (int i = idx+1; i <= N; i++) {
            if (child[idx] < child[i])
                memo[idx] = Math.max(memo[idx], recursion(i) + 1);
        }

        return memo[idx];
    }
}

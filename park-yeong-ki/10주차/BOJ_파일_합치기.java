import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            int K = Integer.parseInt(br.readLine());
            memo = new int[K + 1][K + 1];
            sum = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                Arrays.fill(memo[i], Integer.MAX_VALUE);
                memo[i][i] = 0;
                sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            sb.append(recursion(1, K)).append("\n");
        }

        System.out.println(sb);
    }


    static int recursion(int start, int end) {
        if (memo[start][end] != Integer.MAX_VALUE) {
            return memo[start][end];
        }

        for (int i = start; i < end; i++) {
            memo[start][end] = Math.min(memo[start][end], recursion(start, i) + recursion(i + 1, end));
        }
        memo[start][end] += sum[end] - sum[start - 1];

        return memo[start][end];
    }
}

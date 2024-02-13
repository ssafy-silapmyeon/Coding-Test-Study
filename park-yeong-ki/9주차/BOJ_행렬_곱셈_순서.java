import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static Integer[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        memo = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            memo[i][i] = 0;
        }

        System.out.println(recursion(0, N - 1));
    }

    static int recursion(int start, int end) {
        if (memo[start][end] != null) {
            return memo[start][end];
        } else {
            memo[start][end] = Integer.MAX_VALUE;
        }

        for (int i = start; i < end; i++) {
            memo[start][end] = Math.min(memo[start][end], recursion(start, i) + recursion(i + 1, end) + arr[start][0] * arr[i + 1][0] * arr[end][1]);
        }

        return memo[start][end];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, W;
    static int[] arr;
    static Integer[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        memo = new Integer[T + 1][W + 1];

        recursion(0, 0, 1);

        System.out.println(memo[0][0]);
    }

    static int recursion(int idx, int cnt, int pos) {
        if (idx == T + 1) {
            return 0;
        }

        if (memo[idx][cnt] != null) {
            return memo[idx][cnt];
        }

        int init = pos == arr[idx] ? 1 : 0;
        memo[idx][cnt] = init;

        if (cnt < W) {
            memo[idx][cnt] = Math.max(memo[idx][cnt], init + recursion(idx + 1, cnt + 1, pos == 1 ? 2 : 1));
        }
        memo[idx][cnt] = Math.max(memo[idx][cnt], init + recursion(idx + 1, cnt, pos));

        return memo[idx][cnt];
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] memo;
    static int[] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        box = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        memo = new int[n + 1];

        dfs(0);

        System.out.println(memo[0] - 1);
    }

    static int dfs(int idx) {
        if (memo[idx] != 0) {
            return memo[idx];
        } else {
            memo[idx] = 1;
        }

        for (int i = idx + 1; i < box.length; i++) {
            if (box[idx] < box[i])
                memo[idx] = Math.max(memo[idx], dfs(i) + 1);
        }

        return memo[idx];
    }
}

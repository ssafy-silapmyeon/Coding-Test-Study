import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p = 0;
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] % 2 == 1) cnt++;

            while (cnt > K) {
                if (arr[p++] % 2 == 1) cnt--;
            }

            ans = Math.max(ans, (i - p + 1) - cnt);
        }

        System.out.println(ans);
    }
}

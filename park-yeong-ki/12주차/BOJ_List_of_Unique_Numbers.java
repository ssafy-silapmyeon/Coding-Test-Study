import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        int[] count = new int[100001];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            while (idx < N && count[arr[idx]] < 1) {
                count[arr[idx]]++;
                idx++;
            }

            count[arr[i]]--;
            ans += idx - i;
        }

        System.out.println(ans);
    }
}

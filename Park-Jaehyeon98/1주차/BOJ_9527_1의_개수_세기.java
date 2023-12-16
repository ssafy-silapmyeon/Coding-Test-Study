import java.io.*;
import java.util.*;
public class BOJ_9527_1의_개수_세기 {
    static long[] DP = new long[55];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        setDp();

        long result = calOne(M) - calOne(N-1);
        System.out.print(result);
    }

    static long calOne(long N) {
        long count = N & 1;
        int size = (int) (Math.log(N)/Math.log(2));

        for(int i=size;i>0;i--) {
            if((N & (1L<<i)) != 0L) {
                count += DP[i-1] +(N - (1L<<i) + 1);
                N -= (1L << i);
            }
        }
        return count;
    }

    static void setDp() {
        DP[0] = 1;
        for(int i=1;i<55;i++)
            DP[i] = (DP[i-1] << 1) + (1L << i);
    }
}

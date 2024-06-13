import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int[] kCnt = new int[N];
        for (int i = 0; i < N - 2; i++) {
            if (num[i] < num[N - 1]) {
                kCnt[N - 1] = 0;
            } else {
                kCnt[N - 1] = 1;
            }
            
            for (int j = N - 2; j >= i + 1; j--) {
                if (num[i] < num[j]) {
                    kCnt[j] = kCnt[j + 1];
                    answer += kCnt[j];
                } else {
                    kCnt[j] = kCnt[j + 1] + 1;
                } 
            }
        }
        
        System.out.println(answer);
    }
}

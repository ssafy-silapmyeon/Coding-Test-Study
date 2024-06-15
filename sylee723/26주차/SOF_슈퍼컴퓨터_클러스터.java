import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        answer = 0;
        binarySearch(A, A[0], A[N - 1], B);

        System.out.println(answer);
    }

    static void binarySearch(int[] A, long start, long end, long budget) {
        while (start <= end) {
            long mid = (start + end) / 2;
            long minA = mid;

            long cost = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= minA) {
                    break;
                }
                cost += Math.pow(minA - A[i], 2);                
            }

            if (cost <= budget) {
                answer = Math.max(answer, minA);
                start = mid + 1;
                
                if (minA == A[N - 1] && cost < budget) {
                    long leftB = (budget - cost) / N;
                    end = minA + leftB; // 최대값 변경
                }
            } else {
                end = mid - 1;
            }
        }
    }
}

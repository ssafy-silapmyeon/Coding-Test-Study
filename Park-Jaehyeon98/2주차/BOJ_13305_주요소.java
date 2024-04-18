import java.util.Scanner;

public class BOJ_13305_주요소 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] len = new long[n - 1];
        long[] price = new long[n];

        for (int i = 0; i < n - 1; i++) {
            len[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextLong();
        }

        long sum = 0;
        long min = price[0];

        for (int i = 0; i < n - 1; i++) {
            if (price[i] < min) {
                min = price[i];
            }

            sum += (min * len[i]);
        }

        System.out.println(sum);

    }
}
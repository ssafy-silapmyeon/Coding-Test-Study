import java.util.Scanner;

public class BOJ_방_번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count[] = new int[10];
        while (N != 0){
            count[N % 10]++;
            N /= 10;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (i == 6 || i == 9) continue;
            max = Math.max(max, count[i]);
        }

        int num = (count[6] + count[9]) / 2;
        if ((count[6] + count[9]) % 2 == 1) num++;
        max = Math.max(max, num);

        System.out.println(max);
    }
}

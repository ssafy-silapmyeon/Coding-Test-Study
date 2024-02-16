import java.util.Scanner;

public class Main {
    static int A, C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        int B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(recursion(B));
    }

    static long recursion(int pow) {
        if (pow == 1) {
            return A % C;
        }

        if (pow % 2 == 0) {
            long part = recursion(pow / 2);
            return part * part % C;
        } else {
            long part = recursion((pow - 1) / 2);
            return A % C * part % C * part % C;
        }
    }
}

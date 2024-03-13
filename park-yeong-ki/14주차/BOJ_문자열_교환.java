import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String origin = sc.next();

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) == 'a') a.append('a');
            else b.append('b');
        }
        String complete = a.append(b.toString()).toString();

        int len = complete.length();
        int ans = len;
        int cnt;
        for (int i = 0; i < len; i++) {
            cnt = 0;
            for (int j = 0; j < len; j++) {
                if (origin.charAt(j) != complete.charAt((j + i) % len)) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt / 2);
        }

        System.out.println(ans);
    }
}

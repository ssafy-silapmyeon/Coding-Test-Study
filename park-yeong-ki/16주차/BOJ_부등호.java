import java.util.Scanner;

public class Main {
    static int k;
    static boolean[] visited;
    static char[] cArr;
    static String[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        cArr = new char[k];
        for (int i = 0; i < k; i++) {
            cArr[i] = sc.next().charAt(0);
        }

        visited = new boolean[10];
        ans = new String[2];
        ans[0] = String.valueOf(Long.MIN_VALUE);
        ans[1] = String.valueOf(Long.MAX_VALUE);
        perm(0, "");

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    static void perm(int idx, String str) {
        if (idx == k + 1) {
            long num = Long.parseLong(str);
            if (Long.parseLong(ans[0]) < num) {
                ans[0] = str;
            }
            if (Long.parseLong(ans[1]) > num) {
                ans[1] = str;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (idx != 0 && cArr[idx-1] == '<' && str.charAt(idx-1) - '0' > i) continue;
            if (idx != 0 && cArr[idx-1] == '>' && str.charAt(idx-1) - '0' < i) continue;
            visited[i] = true;
            perm(idx + 1, str + i);
            visited[i] = false;
        }
    }
}

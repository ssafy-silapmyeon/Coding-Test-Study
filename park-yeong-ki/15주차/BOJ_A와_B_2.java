import java.util.*;

public class Main {
    static StringBuilder sb;
    static String S;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        String T = sc.next();

        sb = new StringBuilder();
        ans = 0;
        dfs(T);

        System.out.println(ans);
    }

    static void dfs(String str) {
        if (str.equals(S)){
            ans = 1;
            return;
        }

        if (str.charAt(str.length() - 1) == 'A' && str.length() > S.length()) {
            dfs(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B' && str.length() > S.length()) {
            sb.setLength(0);
            dfs(sb.append(str.substring(1)).reverse().toString());
        }
    }
}

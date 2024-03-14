import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static char[] opr = {'+', '-', ' '};
    static int N;
    static int[] num;
    static List<String> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 0; test_case < T; test_case++) {
            N = sc.nextInt();
            num = new int[N];
            for (int i = 0; i < N; i++) {
                num[i] = i + 1;
            }

            ans = new ArrayList<>();
            perm(0, String.valueOf(num[0]));
            Collections.sort(ans);
            for (String a : ans) {
                sb.append(a).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int calculate(String str) {
        List<Integer> nList = new ArrayList<>();
        List<Character> oList = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                nList.add(Integer.parseInt(temp.toString()));
                temp.setLength(0);
                oList.add(str.charAt(i));
            } else if (str.charAt(i) != ' '){
                temp.append(str.charAt(i));
            }
        }
        nList.add(Integer.parseInt(temp.toString()));

        int sum = nList.get(0);

        for (int i = 0; i < oList.size(); i++) {
            if (oList.get(i) == '+') {
                sum += nList.get(i + 1);
            } else {
                sum -= nList.get(i + 1);
            }
        }

        return sum;
    }

    static void perm(int idx, String str) {
        if (idx == N - 1) {
            if (calculate(str) == 0) {
                ans.add(str);
            }
            return;
        }

        for (char o : opr) {
            perm(idx + 1, str + o + num[idx + 1]);
        }
    }
}

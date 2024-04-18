package footdev._10주차;

import java.util.*;

class PGS_괄호_변환 {
    public String solution(String p) {
        if (isValidStr(p)) {
            return p;
        }

        return solve(p);
    }

    public boolean isValidStr(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }

        return st.isEmpty();
    }

    public String solve(String s) {
        if (s.equals("")) return s;

        // u 문자열 나누기 (더 이상 BBS로 나눌 수 없어야 함.)
        int open = 0, close = 0;
        int idx = 0;
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') open++;
            else close++;

            if (open == close) break;
            idx++;
        }

        String u = s.substring(0, idx + 1);
        String v = s.substring(idx + 1);

        //u가 올바른 문자열 이라면
        if (isValidStr(u)) {
            return u + solve(v);
        }

        //u가 올바르지 않은 문자열 이라면
        else {
            //문자열 u의 앞뒤 문자를 짜르고 뒤집기
            char[] chars = u.substring(1, u.length() - 1).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') chars[i] = ')';
                else chars[i] = '(';
            }
            u = new String(chars);
            return "(" + solve(v) + ")" + u;
        }
    }
}

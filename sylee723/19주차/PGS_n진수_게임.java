import java.util.*;

class Solution {    
    public String solution(int n, int t, int m, int p) {
        String result = gameResult(n, m * t);
        
        String answer = "";
        int idx = p - 1;
        while (answer.length() < t) {
            answer += result.charAt(idx);
            idx += m;
        }

        return answer;
    }
    
    static String gameResult(int n, int len) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < len) {
            String now = Integer.toString(num, n);
            sb.append(now);
            num++;
        }
        
        return sb.toString().toUpperCase();
    }
}
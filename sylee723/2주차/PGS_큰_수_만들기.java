import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        char max;
        int maxIdx;
    
        while (k > 0 && left + k < number.length()) {
            max = number.charAt(left);
            maxIdx = left;
            for (int i = left + 1; i <= left + k; i++) {
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    maxIdx = i;
                }
            }
            
            k -= (maxIdx - left);  
            sb.append(max);
            left = maxIdx + 1;
        }
        
        if (left < number.length() - 1) {
            sb.append(number.substring(left));
        }
        
        String answer = sb.toString();
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String numStr = nToKBase(n, k);
        int answer = 0;
        
        for (String num : numStr.split("0")) {
            if (!num.equals("") && isPrime(Long.parseLong(num)))
                answer++;
        }
        
        return answer;
    }
    
    static String nToKBase(int n, int k) {
        String result = "";
        
        while (n > 0) {
            result = (n % k) + result;
            n /= k;
        }
        
        return result;
    }
    
    static boolean isPrime(long num) {
        if (num == 1)
            return false;
        
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}
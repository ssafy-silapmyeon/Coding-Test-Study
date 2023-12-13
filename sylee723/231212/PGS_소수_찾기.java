import java.util.*;

class Solution {
    static int[] result;
    static boolean[] selected;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        set = new HashSet<>();
        result = new int[numbers.length()];
        selected = new boolean[numbers.length()];
        
        for (int l = 1; l <= numbers.length(); l++) {
            makeNum(0, l, numbers);
        }
        
        
        int answer = set.size();
        return answer;
    }
    
    static void makeNum(int idx, int len, String numbers) {
        if (idx == len) {
            int num = 0;
            int digit = 1;
            for (int i = 0; i < len; i++) {
                num += (result[i] * digit); 
                digit *= 10;
            }
            
            if (!set.contains(num) && isPrime(num)) {
                set.add(num);
            }
            
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!selected[i]) {
                result[idx] = numbers.charAt(i) - '0';
                selected[i] = true;
                makeNum(idx + 1, len, numbers);
                selected[i] = false;
            } 
        }
    }
    
    static boolean isPrime(int num) {
        // 1보다 큰 수 중 1과 자신만을 약수로 가지는 수
        if (num <= 1)
            return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}
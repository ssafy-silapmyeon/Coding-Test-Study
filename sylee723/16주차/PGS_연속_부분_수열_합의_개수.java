import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        int len = elements.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int l = 0; l < len; l++) {
                int idx = (i + l) % len; 
                sum += elements[idx];
                
                set.add(sum);
            }
        }
        
        int answer = set.size();
        return answer;
    }
}
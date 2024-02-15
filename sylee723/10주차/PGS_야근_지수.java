import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        
        while (n > 0) {
            int last = works.length - 1;
            int max = works[last];
            
            if (max == 0) {
                return 0;
            }
            
            for (int i = last; i >= 0; i--) {
                if (n > 0 && works[i] == max) {
                    works[i]--;
                    n--;
                } else {
                    break;
                }
            }
        }
        
        long answer = 0;
        for (int i = 0; i < works.length; i++) {
            answer += works[i] * works[i];
        }
        
        return answer;
    }
}
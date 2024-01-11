import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int idx = citations.length - 1;
        int h = citations[idx];
        int count = 0;
        
        while (true) {
            while (idx >= 0 && citations[idx] >= h) {
                count++;
                idx--;
            }
            
            if (count >= h) {
                break;
            }
            
            h--;
        }
        
        return h;
    }
}
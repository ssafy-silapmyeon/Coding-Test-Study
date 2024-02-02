import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int start = distance - rocks[rocks.length - 1];
        int prev = 0;
        for (int i = 0; i < rocks.length; i++) {
            start = Math.min(start, rocks[i] - prev);
            prev = rocks[i];
        }
        int end = distance;
        
        int answer = binarySearch(start, end, rocks, distance, n);
        return answer;
    }
    
    static int binarySearch(int start, int end, int[] rocks, int distance, int n) {
        int answer = -1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            int count = 0;
            int prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] < prev + mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }
            }
            if (distance < prev + mid) {
                count++;
            }
            
            if (count <= n) {
                start = mid + 1;
                answer = mid;
            } else {
               end = mid - 1; 
            }
        }
        
        return answer;
    }
}
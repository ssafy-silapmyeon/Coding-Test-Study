import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int lIdx = 0;
        int hIdx = people.length - 1;
        while (lIdx <= hIdx) {
            int p1 = people[lIdx];
            
            if (lIdx < hIdx) {
                for (int i = hIdx; i > lIdx; i--) {
                    int p2 = people[i];
                    hIdx--;
                    if (p1 + p2 <= limit) {
                        break;
                    }
                    answer++;
                }
            }
            lIdx++;
            answer++;
        }
        
        return answer;
    }
}
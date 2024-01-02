import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        
        int len = queue1.length;
        
        for (int i = 0; i < len; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < len; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        
        int num;
        int answer = 0;
        while (sum1 != sum2) {
            if (answer > len * 4) {
                answer = -1;
                break;
            }
            
            if (sum1 > sum2) {
                num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num); 
            } else if (sum1 < sum2) {
                num = q2.poll();
                sum1 += num;
                sum2 -= num;
                q1.add(num);
            }
            answer++;
        }
        
        return answer;
    }
}
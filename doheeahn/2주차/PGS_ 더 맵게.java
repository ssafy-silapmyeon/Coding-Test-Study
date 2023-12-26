import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++){
            pq.offer(scoville[i]);
        }
        
        while(pq.peek() < K){
            if(pq.size() ==1){
                answer = -1;
                break;
            }
            answer ++;
            int min1 = pq.poll();
            int min2 = pq.poll();
            
            pq.offer(min1 + min2*2);
        }
        
        return answer;
    }
}
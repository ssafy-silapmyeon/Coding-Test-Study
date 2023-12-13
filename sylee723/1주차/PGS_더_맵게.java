import java.util.*; 

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        int mix;
        while (true) {
            if (pq.peek() >= K)
                break;
            
            if (pq.size() < 2) {
                answer = -1;
                break;
            }
            
            mix = pq.poll() + (pq.poll() * 2);
            pq.add(mix);
            answer++;
        }
        
        return answer;
    }
}
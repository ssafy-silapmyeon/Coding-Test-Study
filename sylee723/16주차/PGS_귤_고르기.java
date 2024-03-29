import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int key : map.keySet()) {
            pq.add(map.get(key));
        }
        
        int total = 0;
        int answer = 0;
        
        while (total < k) {
            int count = pq.poll();
            total += count;
            answer++;
        }
        
        return answer;
    }
}
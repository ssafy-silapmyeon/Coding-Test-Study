import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] count = new int[10];
        for (int i = 0; i < priorities.length; i++) {
            count[priorities[i]]++;
            queue.add(i);
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            boolean execute = true;
            for (int i = priorities[now] + 1; i <= 9; i++) {
                if (count[i] > 0) {
                    execute = false;
                    break;
                }
            }
            
            if (execute) {
                count[priorities[now]]--;
                answer++;
                if (now == location) {
                    break;
                }
            } else {
                queue.add(now);
            }
        }
        
        return answer;
    }
}
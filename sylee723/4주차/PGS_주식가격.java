import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] pop = stack.pop();
                answer[pop[0]] = i - pop[0];
            }
            
            stack.push(new int[] {i, prices[i]});
        }
        
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            answer[pop[0]] = prices.length - 1 - pop[0];
        }
        
        return answer;
    }
}
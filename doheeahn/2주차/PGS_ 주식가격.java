import java.util.*;
class Solution {
    static class price{
        int idx;
        int p;
            
        public price(int idx, int p){
            this.idx = idx;
            this.p = p;
        }
    }
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<price> stack = new Stack<>();
        stack.push(new price(0,prices[0]));
        
        for(int i=1;i<prices.length;i++){
            if(stack.peek().p<=prices[i]){
                stack.push(new price(i,prices[i]));
            }
            else{
                while(stack.size()>0 && stack.peek().p > prices[i]){
                    price cur = stack.pop();
                    answer[cur.idx] = i - cur.idx;
                }
                stack.push(new price(i,prices[i]));
            }  
        }
        int n = stack.size();
        while(stack.size() > 0){
            price cur = stack.pop();
            answer[cur.idx] = prices.length - cur.idx-1;
        }
        return answer;
    }
}
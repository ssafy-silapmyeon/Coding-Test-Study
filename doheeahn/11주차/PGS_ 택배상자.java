import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int cur =1;//지금 벨트 순서
        int box = 0;//기사님 순서
        Stack<Integer> stack = new Stack<>();
        
        while(cur <= order.length){
            if(order[box] == cur){
                answer ++;
                cur ++;
                box ++;
                while(!stack.isEmpty() && stack.peek() == order[box]){
                    stack.pop();
                    answer ++;
                    box++;
                }
            }
            else{
                stack.push(cur);
                cur++;
            }
        }
        return answer;
    }
}
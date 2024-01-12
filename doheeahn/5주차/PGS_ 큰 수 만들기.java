import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        stack.push(number.charAt(0)-'0');
        int cnt=0;
        
        for(int i=1;i<number.length();i++){
            int cur = stack.peek();
            if( cnt <k && cur < number.charAt(i)-'0'){
                while(cnt<k &&cur < number.charAt(i)-'0'){
                    stack.pop();
                    cnt++;
                    if(stack.size()==0){
                        break;
                    }
                    cur = stack.peek();
                }
                stack.push(number.charAt(i)-'0');
            }
            else{
                stack.push(number.charAt(i)-'0');
            }

        }
        for(int i=0;i<k-cnt;i++){
            stack.pop();
        }
        int n = stack.size();
        for(int i=0;i<n;i++){
            answer = stack.pop()+answer;
        }
        return answer;
    }
}
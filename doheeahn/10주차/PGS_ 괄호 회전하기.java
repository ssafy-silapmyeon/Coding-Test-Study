import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean ans = true;
        char[] arr = new char[s.length()];
        
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        
        int len = s.length();
        for(int i=0;i<len;i++){
            int cnt =0;
            ans = true;
            Stack<Character> stack = new Stack<>();
            while(cnt < len){
                if(arr[(i+cnt)%len]==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        ans = false;
                        break;
                    }
                    cnt++;
                }
                else if(arr[(i+cnt)%len]==']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        ans = false;
                        break;
                    }
                    cnt++;
                }
                else if(arr[(i+cnt)%len]=='}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        ans = false;
                        break;
                    }
                    cnt++;
                }
                else{
                    stack.push(arr[(i+cnt)%len]);
                    cnt ++;                
                }
            }
            if(ans && stack.isEmpty()){
                answer++;
            }
        }

        
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = recursion(p);
        return answer;
    }
    
    static boolean isRight(String u){
        Stack<Character> stack = new Stack();
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return true;
    }
    
    static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        return sb.toString();
    }
    
    static String recursion(String w){
        if(w.length() == 0){ //1번
            return w;
        }
        
        int cnt1 = 0;
        int cnt2 = 0;
        int idx = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '('){
                cnt1++;
            }else{
                cnt2++;
            }
            
            if((cnt1 > 0 && cnt2 > 0) && cnt1 == cnt2){
                idx = i;
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        String u = w.substring(0, idx+1); //2번
        String v = w.substring(idx+1, w.length()); //2번

        if(isRight(u)){ //3번
            return sb.append(u).append(recursion(v)).toString();
        }else{ //4번
            return sb.append('(').append(recursion(v)).append(')').append(reverse(u.substring(1,u.length()-1))).toString();
        }
    }
}

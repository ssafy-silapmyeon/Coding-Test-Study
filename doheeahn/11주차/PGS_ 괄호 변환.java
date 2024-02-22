import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        answer = split(p);
        
        return answer;
    }
    
    public String split(String w){
        String u = "";
        String v = "";
        int o =0;
        int c = 0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i) == '('){
                o++;
            }
            else{
                c++;
            }
            if(o==c){
                u = w.substring(0,i+1);
                if(i != w.length()-1){
                    v = w.substring(i+1,w.length());
                }
                break;
            }
        }

        if(u.length()==0){
            return u;
        }
        
        if(right(u)){// 올바른 괄호 문자열
            u += split(v);
        }
        else{
            String tmp = "(";
            tmp += split(v);
            tmp +=")";
            for(int s =1;s<u.length()-1;s++){
                if(u.charAt(s)=='('){
                    tmp += ")";
                }
                else{
                    tmp += "(";
                }
            }
            u = tmp;    
        }
        return u;
        
    }
    
    public boolean right(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty() || stack.pop() == ')' ){
                    return false;
                }
            }
        }
        return true;
    }
}
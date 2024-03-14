import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        boolean word = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                word = true;
                answer += Character.toString(s.charAt(i));
            }
            
            else if(word){
                if('a'<=s.charAt(i) && s.charAt(i)<='z'){
                    answer += Character.toString(s.charAt(i) + ('A'-'a'));
                }
                else{
                    answer += Character.toString(s.charAt(i));
                }
                word = false;
            }
            else if (!word && 'A'<=s.charAt(i) && s.charAt(i)<='Z'){
                answer += Character.toString(s.charAt(i) - ('A'-'a'));
            }
            else{
                answer += Character.toString(s.charAt(i));
            }
            
        }
        return answer;
    }
}
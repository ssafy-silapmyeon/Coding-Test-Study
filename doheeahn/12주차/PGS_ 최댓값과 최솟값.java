import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        
        while(st.countTokens()>0){
            int cnt = Integer.parseInt(st.nextToken());
            if(min > cnt){
                min = cnt;
            }
            else if(max < cnt){
                max = cnt;
            }
        }
        answer = Integer.toString(min)+" "+ Integer.toString(max);
        return answer;
    }
}
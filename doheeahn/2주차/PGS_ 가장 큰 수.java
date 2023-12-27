import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (o1,o2)-> (o2+o1).compareTo(o1+o2));
        
        StringBuilder sb = new StringBuilder();
        for(String s : num){
            sb.append(s);
        }
        answer = sb.toString();
        
        if(answer.charAt(0) =='0'){
            answer = "0";
        }
        return answer;
    }
}
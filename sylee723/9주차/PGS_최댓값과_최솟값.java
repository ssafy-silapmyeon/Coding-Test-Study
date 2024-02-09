import java.util.*; 

class Solution {
    public String solution(String s) {
        String[] numStr = s.split(" ");
        int[] num = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        
        Arrays.sort(num);
        
        String answer = num[0] + " " + num[num.length - 1];
        return answer;
    }
}
class Solution {
    public String solution(int n) {
        int power = 3;
        int len = 1;
        while (n > power) {
            n -= power;
            power *= 3;
            len++;
        }
        
        String answer = "";
        for (int i = 0; i < len; i++) {
            int num = n % power == 0 ? power : n % power;
            if (num <= power / 3) {
                answer += '1';
            } else if (power / 3 < num && num <= 2 * power / 3) {
                answer += '2';
            } else {
                answer += '4';
            }
            
            power /= 3;
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";
        char prev = ' ';
        
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (prev == ' ') {
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    now = (char)(s.charAt(i) + ('A' - 'a'));
                }
            } else {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                    now = (char)(s.charAt(i) - ('A' - 'a'));
                }
            }
            
            answer += now;
            prev = s.charAt(i);
        }
        
        return answer;
    }
}
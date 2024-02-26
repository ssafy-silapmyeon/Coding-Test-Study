class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int l = 1; l <= s.length() / 2; l++) {
            int count = 1;
            int len = s.length() % l;
            String prev = s.substring(0, l);
            
            for (int i = l; i + l <= s.length(); i += l) {
                String now = s.substring(i, i + l);
                
                if (prev.equals(now)) {
                    count++;
                } else {
                    len += l;
                    if (count > 1) {
                        String num = count + "";
                        len += num.length();  
                    }
                    count = 1;
                }
                prev = now;
            }
            
            len += l;
            if (count > 1) {
                String num = count + "";
                len += num.length();
            }
            
            answer = Math.min(answer, len);
        }
        
        return answer;
    }
}
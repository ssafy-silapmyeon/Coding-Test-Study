class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }
            
            int len = s.length() - count;
            answer[1] += count;
            
            s = changeNumBinary(len);
            answer[0]++;
        }
        
        return answer;
    }
    
    static String changeNumBinary(int n) {
        String r = "";
        while (n > 0) {
            r += (n % 2);
            n /= 2;
        }
        
        String b = "";
        for (int i = r.length() - 1; i >= 0; i--) {
            b += r.charAt(i);
        }
        
        return b;
    }
}
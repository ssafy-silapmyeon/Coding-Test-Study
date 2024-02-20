class Solution {
    public String solution(String p) {
        String answer = transform(p);
        return answer;
    }
    
    static String transform(String w) {
        if (w.equals(""))
            return "";
        
        int idx = separateUV(w);
        
        String u = w.substring(0, idx);
        String v = w.substring(idx);

        if (isCorrect(u)) {
            return u + transform(v);
        } else {
            String t_u = "";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    t_u += ")";
                } else {
                    t_u += "(";
                }  
            }
            return "(" + transform(v) + ")" + t_u;
        }
    }
    
    static int separateUV(String p) {
        int idx = 0;
        int left = 0;
        int right = 0;
        
        while (idx < p.length()) {
            if (p.charAt(idx) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                return idx + 1;
            }
            idx++;
        }
        
        return idx;
    }
    
    static boolean isCorrect(String p) {
        int idx = 0;
        int left = 0;
        
        while (idx < p.length()) {
            if (p.charAt(idx) == '(') {
                left++;
            } else {
                if (left == 0)
                    return false;
                left--;
            }

            idx++;
        }
        
        if (left == 0) {
            return true;
        }

        return false;
    }
}
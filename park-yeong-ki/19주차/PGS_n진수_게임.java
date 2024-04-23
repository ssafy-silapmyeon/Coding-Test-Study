import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        
        String str;
        outer:
        while(true){
            str = Integer.toString(num, n).toUpperCase();
            
            for(int i=0; i<str.length(); i++){
                if(idx%m == p-1){
                    sb.append(str.charAt(i));
                    if(sb.length() == t){
                        break outer;
                    }
                }
                idx++;
            }
            num++;
        }

        return sb.toString();
    }
}

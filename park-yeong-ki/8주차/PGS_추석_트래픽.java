import java.util.*;

class Solution {
    public int solution(String[] lines) {
        long[][] times = new long[lines.length][2];
        String[] t;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lines.length; i++){
            t = lines[i].split(" ");
            times[i][1] = tToms(t[1]);
            
            boolean flag = false;
            for(int j=0; j<t[2].length() - 1; j++){
                if(t[2].charAt(j) == '.'){
                    times[i][0] = Long.parseLong(sb.toString()) * 1000;
                    sb.setLength(0);
                    flag = true;
                }
                else sb.append(t[2].charAt(j));
            }
            if(flag) times[i][0] += Long.parseLong(sb.toString());
            else times[i][0] += Long.parseLong(sb.toString()) * 1000;
            sb.setLength(0);
            
            times[i][0] = times[i][1] - times[i][0] + 1;
        }
        
        int ans = 1;
        for(int i=0; i<times.length; i++){
            int cnt = 1;
            for(int j=i+1; j<times.length; j++){
                if(times[i][1] + 1000 > times[j][0]) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
    
    
    
    static long tToms(String str){
        long ms = 0;
        
        String[] sArr = str.split(":");
        ms += Long.parseLong(sArr[0]) * 3600 * 1000;
        ms += Long.parseLong(sArr[1]) * 60 * 1000;
        ms += Long.parseLong(sArr[2].replace(".", ""));
        
        return ms;
    }
}

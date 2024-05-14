import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        String melody;
        String[] info;
        int minute;
        int aMinute = -1;
        for(int i=0; i<musicinfos.length; i++){
            info = musicinfos[i].split(",");
            minute = getMinute(info);
            melody = getMelody(info[3], minute);    
            if(isContain(m, melody) && aMinute < minute){
                aMinute = minute;
                answer = info[2];
            }
        }
        
        return answer;
    }
    
    static boolean isContain(String str1, String str2){
        if(str1.length() > str2.length()) return false;
        
        int len = str1.length();
        for(int i=0; i<=str2.length() - len; i++){
            if(str2.substring(i, i+len).equals(str1) && 
              ((i+len < str2.length() && str2.charAt(i+len) != '#') 
               || i+len == str2.length())){
                return true;
            }
        }
        
        return false;
    }
    
    static int getMinute(String[] info){
        String[] start = info[0].split(":");
        String[] end = info[1].split(":");
        
        int minute = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
        minute += Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        
        return minute;
    }
    
    static String getMelody(String str, int minute){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(minute-- > 0){
            sb.append(str.charAt(idx++));
            if(idx < str.length() && str.charAt(idx) == '#'){
                sb.append(str.charAt(idx++));
            }
            idx %= str.length();
        }
        
        return sb.toString();
    }
}

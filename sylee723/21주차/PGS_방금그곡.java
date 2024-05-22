import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String listen = changeStr(m);
        String answer = "(None)";
        int maxTime = -1;
        
        for (String info : musicinfos) {
            String[] data = info.split(",");
            int start = timeStrToMin(data[0]);
            int end = timeStrToMin(data[1]);
            int play = end - start; 
            String title = data[2];
            String music = changeStr(data[3]);
            
            String playedMusic = "";
            int left = play;
            while (left > 0) {
                if (left >= music.length()) {
                    playedMusic += music;
                    left -= music.length();
                } else {
                    playedMusic += music.substring(0, left);
                    break;
                }
            }
            
            if (playedMusic.contains(listen) && maxTime < play) {
                answer = title;
                maxTime = play;
            }
        }
        
        return answer;
    }
    
    static String changeStr(String m) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int len = m.length();
        while (i < len) {
            if ((i + 1 == len) || (i + 1 < len && m.charAt(i + 1) != '#')) {
                result.append(m.charAt(i));
                i++;
            } else {
                result.append((char)(m.charAt(i) + 'a' - 'A'));
                i += 2;
            }
        }
        
        return result.toString();
    }
    
    static int timeStrToMin(String hhmm) {
        String[] time = hhmm.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        
        return hour * 60 + min;
    }
}
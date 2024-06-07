class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = timeToSec(play_time);
        long[] d = new long[playSec + 1];
        
        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split("-");
            int start = timeToSec(log[0]);
            int end = timeToSec(log[1]);
            
            d[start] += 1;
            d[end] -= 1;
        }
        
        for (int i = 1; i < d.length; i++) {
            d[i] += d[i - 1];
        }
        
        int advSec = timeToSec(adv_time);      
        long timeSum = 0;
        for (int i = 0; i < advSec; i++) {
            timeSum += d[i];
        }
        
        int left = 0;
        int right = advSec;
        int start = 0;
        long maxTime = timeSum;
        while (right < playSec) {
            timeSum += d[right];
            timeSum -= d[left];
            
            if (maxTime < timeSum) {
                start = left + 1;
                maxTime = timeSum;
            }
            
            left++;
            right++;
        }
        
        String answer = secToTime(start);
        return answer;
    }
    
    static int timeToSec(String time) {
        String[] splitTime = time.split(":");
        int h = Integer.parseInt(splitTime[0]);
        int m = Integer.parseInt(splitTime[1]);
        int s = Integer.parseInt(splitTime[2]);
        
        return h * 60 * 60 + m * 60 + s;
    }
    
    static String secToTime(int sec) {
        int h = sec / (60 * 60);
        sec %= 60 * 60;
        int m = sec / 60;
        sec %= 60;
        
        String ret = "";
        if (h < 10) {
            ret += "0";
        }
        ret += h;
        ret += ":";
        
        if (m < 10) {
            ret += "0";
        }
        ret += m;
        ret += ":";
        
        if (sec < 10) {
            ret += "0";
        }
        ret += sec;
        return ret;
    }
}
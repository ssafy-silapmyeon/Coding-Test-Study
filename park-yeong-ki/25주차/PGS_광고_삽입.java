import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        int ps = timeToSecond(play_time);
        
        int[] totalTime = new int[ps+1];
        
        int start;
        int end;
        String[] sArr;
        for(String log : logs){
            sArr = log.split("-");
            start = timeToSecond(sArr[0]);
            end = timeToSecond(sArr[1]);
            totalTime[start]++;
            totalTime[end]--;
        }
        
        for(int i=1; i<=ps; i++){
            totalTime[i] += totalTime[i-1];
        }
        
        int as = timeToSecond(adv_time);
        long sum = 0;
        long max = 0;
        int idx = 0;
        int ans = 0;
        for(int i=0; i<=ps; i++){
            if(i >= as){
                sum -= totalTime[idx++];
            }
            sum += totalTime[i];
            
            if(max < sum){
                max = sum;
                ans = idx;
            }
        }        
        
        return secondToTime(ans);
    }
    
    String secondToTime(int second){
        StringBuilder time = new StringBuilder();
        int m = 3600;
        while(true){
            if((second / m) / 10 == 0){
                time.append(0);
            }
            time.append(second / m);
            second %= m;
            
            m /= 60;
            if(m == 0) break;
            
            time.append(":");
        }
        
        return time.toString();
    }
    
    int timeToSecond(String time){
        String[] sArr = time.split(":");
        int s = 0;
        int p = 3600;
        
        for(String str : sArr){
            s += Integer.parseInt(str) * p;
            p /= 60;
        }
        
        return s;
    }
}

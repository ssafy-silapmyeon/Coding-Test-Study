import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] minutes = new int[timetable.length];
        String[] time;
        for(int i=0; i<timetable.length; i++){
            time = timetable[i].split(":");
            minutes[i] += Integer.parseInt(time[0]) * 60;
            minutes[i] += Integer.parseInt(time[1]);
        }
        Arrays.sort(minutes);
        
        int[] shuttle = new int[n];
        shuttle[0] = 9 * 60;
        for(int i=1; i<n; i++){
            shuttle[i] += shuttle[i-1] + t;
        }
        
        int cnt = 0;
        int idx = 0;
        for(int i=0; i<shuttle.length; i++){
            cnt = 0;
            for(int j=idx; j<minutes.length; j++){
                if(shuttle[i] >= minutes[j]){
                    cnt++;
                    idx++;
                }
                
                if(cnt == m) break;
            }
        }
        
        int ans = 0;        
        if(cnt < m) ans = shuttle[shuttle.length-1];
        else if(cnt == m) ans = minutes[idx-1] - 1;
        
        String H = String.valueOf(ans / 60);
        if(H.length() == 1) H = "0" + H;
        
        String M = String.valueOf(ans % 60);
        if(M.length() == 1) M = "0" + M;
        
        return H+":"+M;
    }
}

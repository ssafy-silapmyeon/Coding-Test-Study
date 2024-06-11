import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int time = video(play_time);
        long[] adv = new long[time+1];
        long result =0;
        int ans=0;
        
        for(int i=0;i<logs.length;i++){
            StringTokenizer st = new StringTokenizer(logs[i],"-");
            int s = video(st.nextToken());
            int e = video(st.nextToken());
            adv[s]++;
            adv[e]--;
        }
        
        for(int i=0;i<time;i++){
            adv[i+1] += adv[i]; //해당 i시간에 몇명이 재생 했는지
        }
        
        for(int i=0;i<time;i++){
            adv[i+1] += adv[i]; //해당 i시간에 누적
        }
        
        int s =0;
        int e = video(adv_time);
        
        while(e <= time){
            if(s==0){
                if(result < adv[e-1]-adv[s]){
                    result = adv[e-1]-adv[s];
                    ans = s;
                }

            }

            else{
                if(result < adv[e-1]-adv[s-1]){
                    result = adv[e-1]-adv[s-1];
                    ans = s;
                }
            }
            
            s++;
            e++;
        }
        
        String se = Integer.toString(ans%60);
        ans/=60;
        String m = Integer.toString(ans%60);
        String h = Integer.toString(ans/60);
        if(h.length()==1){
            h="0"+h;
        }
        if(m.length()==1){
            m="0"+m;
        }
        if(se.length()==1){
            se="0"+se;
        }
        answer = h+":"+m+":"+se;
        
        

         return answer;
    }
    public int video(String s){
        StringTokenizer st = new StringTokenizer(s,":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int se = Integer.parseInt(st.nextToken());
        int time = h*60*60 + m*60+ se; //전체 동영상 길이
        
        return time;
    }
}
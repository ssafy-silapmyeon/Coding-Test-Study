import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int ml =0;
        for(int i=0;i<musicinfos.length;i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i],",|:");
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            if(em <sm){
                eh--;
                em +=60;
            }
            String title = st.nextToken();
            int music = (eh - sh) * 60 + (em - sm);
            System.out.println(music);
            if(title(m,st.nextToken(),music) && ml < music){
                ml = music;
                answer = title;
            }  
        }
        return answer;
    }
    
    public boolean title(String m, String info, int t){
        int it =0;
        for(int i=0;i<info.length();i++){
            if(info.charAt(i)=='#'){
                continue;
            }
            it++; // it 만큼의 시간 지남
            
            int mt =0;
            for(int j=0;j<m.length();j++){
                if(m.charAt(j)!='#'){
                    mt++;
                }
                
                if(it+mt-1>t){
                    return false;
                }
                if(m.charAt(j) != info.charAt((i+j)%info.length())){
                    break;
                }
                if(j == m.length()-1){
                    if(info.charAt((i+j+1)%info.length())=='#'){
                        break;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
    
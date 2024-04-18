import java.util.*;
class Solution {
    static Map<String,Integer> map;
    static int answer =0;
    public int solution(String[] want, int[] number, String[] discount) {
        map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        init(discount);
        check();
        for(int i=0;i<discount.length-10;i++){
            sliding(i,discount);
            check();
        }
        return answer;
    }
    public void sliding(int i, String[] discount){
        if(map.get(discount[i])!=null){
            map.put(discount[i],map.get(discount[i])+1);
        }
        if(map.get(discount[i+10])!=null){
            map.put(discount[i+10],map.get(discount[i+10])-1);
        }
    }
    public void init(String[] discount){
        for(int i=0;i<10;i++){
            if(map.get(discount[i])!=null){
                map.put(discount[i],map.get(discount[i])-1);
            }
        }
    }
    public void check(){
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>0){
              return;  
            }
        }
        answer++;
        return;
        
    
    }
}
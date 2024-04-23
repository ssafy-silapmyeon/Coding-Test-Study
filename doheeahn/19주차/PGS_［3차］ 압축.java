import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        HashMap<String,Integer> map = new HashMap<>();
        char c = 'A';
        int n =1;
        ArrayList<Integer> list = new ArrayList<>();
        while(c <='Z'){
            String s = Character.toString(c);
            map.put(s,n);
            c++;
            n++;
        }
        
        String cur ="";
        int num = 0;
        int i=0;
        while(i < msg.length()){
            cur += msg.substring(i,i+1);
            if(map.containsKey(cur)){
                num = map.get(cur);
                i++;
            }
            else{
                map.put(cur,n);
                list.add(num);
                n++;
                cur = "";
                num =0;
            }
        }
        list.add(num);
        
        int[] answer = new int[list.size()];
        int idx =0;
        for(int l : list){
            answer[idx] =l;
            idx++;
        }
        
        return answer;
    }
}
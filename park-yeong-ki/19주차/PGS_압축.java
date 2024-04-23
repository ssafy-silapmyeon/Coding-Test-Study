import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        for(int i=65; i<=90; i++){
            dict.put(String.valueOf((char) i), idx++);
        }

        List<Integer> list = new ArrayList<>();
        int s=0;
        while(s < msg.length()){
            String str;
            for(int j=msg.length(); j>s; j--){
                str = msg.substring(s, j);
                
                if(dict.containsKey(str)){
                    list.add(dict.get(str));
                    
                    if(j != msg.length()){
                        dict.put(str + msg.charAt(j), idx++);
                    }
                    
                    s = j;
                    break;
                }
                
            }    
        }
        
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}

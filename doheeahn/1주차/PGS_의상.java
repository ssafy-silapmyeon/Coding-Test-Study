import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){

            if(map.containsKey(clothes[i][1])){
                int n = map.get(clothes[i][1]);
                map.put(clothes[i][1],n+1);
            }
            else{
                map.put(clothes[i][1],1);
            }
        }
        
        for(int i : map.values()){
            answer *=(i+1); 
        }
    
        return answer-1;
    }
}
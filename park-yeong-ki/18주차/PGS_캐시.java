import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new ArrayDeque<>();
        int ans = 0;
        for(int i=0; i<cities.length; i++){
            cities[i] = cities[i].toLowerCase();
            
            int size = cache.size();
            String current;
            boolean flag = false;
            while(size-- > 0){
                current = cache.poll();
                if(cities[i].equals(current)){
                    flag = true;
                }else{
                    cache.add(current);
                }
            }
            cache.add(cities[i]);
            
            if(flag){
                ans += 1;
            }else{
                ans += 5;
                if(cache.size() > cacheSize) cache.poll();
            }
            
        }
        
        return ans;
    }
}

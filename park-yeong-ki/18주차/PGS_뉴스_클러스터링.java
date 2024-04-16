import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> map1 = makeSet(str1);
        Map<String, Integer> map2 = makeSet(str2);
        
        Set<String> set = new HashSet<>();
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        
        int size1 = 0;
        int size2 = 0;
        for(String key : set){
            size1 += Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
            size2 += Math.max(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0));
        }
        
        int ans = 65536;
        if(map1.size() != 0 || map2.size() != 0){
            ans = size1 * 65536 / size2;
        }
        
        return ans;
    }
    
    static Map<String, Integer> makeSet(String str){
        Map<String, Integer> map = new HashMap<>();
        String s;
        boolean flag;
        for(int i=0; i<str.length()-1; i++){
            s = str.substring(i, i+2);
            flag = true;
            for(int j=0; j<2; j++){
                if('A' > s.charAt(j) || s.charAt(j) > 'Z'){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        return map;
    }
}

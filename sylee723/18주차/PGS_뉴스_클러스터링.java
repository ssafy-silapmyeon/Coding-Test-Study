import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = findElement(str1);
        Map<String, Integer> map2 = findElement(str2);
        
        Set<String> intersection = new HashSet<>();
        Set<String> union = new HashSet<>();
        
        intersection.addAll(map1.keySet());
        intersection.retainAll(map2.keySet());
        union.addAll(map1.keySet());
        union.addAll(map2.keySet());
        
        int iCnt = 0;
        int uCnt = 0;
        for (String e : intersection) {
            iCnt += Math.min(map1.get(e), map2.get(e));
        }
        for (String e : union) {
            uCnt += Math.max(map1.getOrDefault(e, 0), map2.getOrDefault(e, 0));
        }
        
        if (uCnt == 0) {
            return 65536;
        }
        return (int)Math.floor((float)iCnt / uCnt * 65536);
    }
    
    static Map<String, Integer> findElement(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        str = str.toLowerCase();
        for (int i = 0; i < str.length() - 1; i++) {
            int ch1 = str.charAt(i);
            int ch2 = str.charAt(i + 1);
            if ((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) {
                map.put(str.substring(i, i + 2), map.getOrDefault(str.substring(i, i + 2), 0) + 1);
            }
        }
        
        return map;
    }
} 
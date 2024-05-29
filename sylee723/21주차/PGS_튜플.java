import java.util.*;

class Solution {
    static Map<Integer, Set<Integer>> lenSet;
    static int tupleLen;
    public int[] solution(String s) {
        tupleLen = 0;
        strToSet(s);
        
        int[] answer = new int[tupleLen];
        Set<Integer> now, prev;
        prev = new HashSet<>();
        
        for (int i = 1; i <= tupleLen; i++) {
            now = lenSet.get(i);

            for (int num : now) {
                if (!prev.contains(num)) {
                    answer[i - 1] = num;
                    break;
                }
            }
            
            prev = now;
        }
        return answer;
    }
    
    static void strToSet(String s) {
        lenSet = new HashMap<>();
        
        int idx = 1;
        while (idx < s.length() - 1) {
            int start = idx;
            int end = start + 1;
            while (s.charAt(end) != '}') {
                end++;
            }
            
            Set<Integer> set = new HashSet<>();
            for (String data : s.substring(start + 1, end).split(",")) {
                set.add(Integer.parseInt(data));
            }
            
            tupleLen = Math.max(tupleLen, set.size());
            lenSet.put(set.size(), set);
            
            idx = end + 2;
        }
    }
}
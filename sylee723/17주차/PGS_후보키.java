import java.util.*;

class Solution {
    static boolean[] selected;
    static List<Integer> keyList = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int count = relation[0].length;
        selected = new boolean[count];
        
        for (int c = 1; c <= count; c++) { // 후보키 구성 속성 개수 
            comb(0, 0, c, relation);
        }
        
        int answer = keyList.size();
        return answer;
    }
    
    static void comb(int start, int count, int end, String[][] relation) {
        if (count == end) {
            int key = 0;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    key |= (1 << i);
                }
            }
            
            if (isCandidateKey(key, relation)) {
                keyList.add(key);
            }

            return;
        }
        
        for (int i = start; i < selected.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                comb(i + 1, count + 1, end, relation);
                selected[i] = false; 
            }
        }
    }
    
    static boolean isCandidateKey(int key, String[][] relation) {
        for (int existingKey : keyList) {
            if ((existingKey & key) == existingKey) {
                return false;
            }
        }
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            String tuple = "";
            for (int s = 0; s < selected.length; s++) {
                if (selected[s]) {
                    tuple += relation[i][s];
                }
            }
            
            set.add(tuple);
        }
        
        if (set.size() != relation.length) {
            return false;
        }
        
        return true;
    }
}
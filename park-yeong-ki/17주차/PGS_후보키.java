import java.util.*;

class Solution {
    static int num, row, col;
    static String[][] sRelation;
    static List<Integer> keys;
    public int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        sRelation = relation;
        
        keys = new ArrayList<>();
        for(int i=1; i<=col; i++){
            num = i;
            comb(0, 0, 0);
        }
        
        return keys.size();
    }
    
    static boolean isUnique(int key){
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(int i=0; i<sRelation.length; i++){
            for(int j=0; j<col; j++){
                if((key & 1<<j) != 0){
                    sb.append(sRelation[i][j]);
                }
            }
            
            if(set.contains(sb.toString())) return false;
            set.add(sb.toString());
            sb.setLength(0);
        }
        
        return true;
    }
    
    static boolean isMinimal(int key){
        for(int cKey : keys){
            int min = 0;
            for(int i=0; i<col; i++){
                if((cKey & (1<<i)) != 0 && (key & (1<<i)) != 0){
                    min |= 1<<i;
                }
            }
            
            if(cKey == min) return false;
        }
        
        return true;
    }
    
    static void comb(int start, int cnt, int key){
        if(num == cnt){
            if(isUnique(key) && isMinimal(key)){
                keys.add(key);
            }
            
            return;
        }
        
        for(int i=start; i<col; i++){
            comb(i+1, cnt+1, key | (1<<i));
        }
    }
    
}

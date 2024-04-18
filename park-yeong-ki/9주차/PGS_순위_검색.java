import java.util.*;

class Solution {
    static String[] sArr;
    static Map<String, List<Integer>> conditionMap;
    
    public int[] solution(String[] info, String[] query) {
        conditionMap = new HashMap<>();
        
        for(int i=0; i<info.length; i++){
            sArr = info[i].split(" ");
            subset(0, "");
        }
        
        for(String key : conditionMap.keySet()){
            Collections.sort(conditionMap.get(key));
        }
        
        int[] ans = new int[query.length];
        for(int i=0; i<query.length; i++){
            sArr = query[i].replace(" and ", "").split(" ");
            
            if(conditionMap.containsKey(sArr[0])){
                ans[i] = binarySearch(conditionMap.get(sArr[0]), Integer.parseInt(sArr[1]));
            }else{
                ans[i] = 0;
            }
        }
        
        return ans;
    }
    
    static int binarySearch(List<Integer> scores, int X){
        int start = 0;
        int end = scores.size()-1;
        int mid;
        while(start < end){
            mid = (start + end) / 2;
            
            if(scores.get(mid) < X){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        
        if(scores.get(end) >= X) return scores.size() - end;
        else return 0;
    }
    
    static void subset(int idx, String condition){
        if(idx == 4){
            if(!conditionMap.containsKey(condition)){
                conditionMap.put(condition, new ArrayList<>());
            }
            conditionMap.get(condition).add(Integer.parseInt(sArr[idx]));
            
            return;
        }
        
        subset(idx+1, condition + sArr[idx]);
        subset(idx+1, condition + "-");
    }
}

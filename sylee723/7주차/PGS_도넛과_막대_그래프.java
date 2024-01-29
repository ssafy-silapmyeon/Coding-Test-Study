import java.util.*;

class Solution {
    static Map<Integer, ArrayList<Integer>> outMap;
    
    public int[] solution(int[][] edges) {
        outMap = new HashMap<>();
        Set<Integer> notCreatedSet = new HashSet<>();
        
        for (int i = 0; i < edges.length; i++) {
            if (outMap.containsKey(edges[i][0])) {
                ArrayList<Integer> eList = outMap.get(edges[i][0]);
                eList.add(edges[i][1]);
                outMap.put(edges[i][0], eList);
            } else {
                ArrayList<Integer> eList = new ArrayList<>();
                eList.add(edges[i][1]);
                outMap.put(edges[i][0], eList);
            }
            
            notCreatedSet.add(edges[i][1]);
        }
        
        int created = 0;
        for (int key : outMap.keySet()) {
            if (outMap.get(key).size() >= 2 && !notCreatedSet.contains(key)) {
                created = key;
                break;
            }
        }
        
        int[] answer = new int[4];
        answer[0] = created;

        for (int v : outMap.get(created)) {
            int idx = graphType(v);
            answer[idx]++;
        }
        
        return answer;
    }
    
    static int graphType(int start) {
        // 도넛 1, 막대 2, 8자 3
        int now = start;
        while (true) {
            if (outMap.get(now) != null && outMap.get(now).size() == 2) {
                return 3;
            }
            
            if (outMap.get(now) == null) {
                return 2;
            }
            
            now = outMap.get(now).get(0);
            if (now == start) {
                return 1;
            }
        }
    }
}
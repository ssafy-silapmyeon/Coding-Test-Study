import java.util.*;

class Solution {
    static Map<String, ArrayList<String>> map;
    static Map<String, boolean[]> visited;
    static String[] result, answer;
    static boolean finish;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] t1, String[] t2) {
                return t1[1].compareTo(t2[1]);
            }
        });
        
        map =  new HashMap<>();
        
        for (int i = 0; i < tickets.length; i++) {
            String a = tickets[i][0];
            String b = tickets[i][1];
            
            if (map.containsKey(a)) {
                ArrayList<String> temp = map.get(a);
                temp.add(b);
                map.put(a, temp);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(b);
                map.put(a, temp);
            }
        }
        
        visited = new HashMap<>();
        for (String key : map.keySet()) {
            int len = map.get(key).size();
            visited.put(key, new boolean[len]);
        }
        
        result = new String[tickets.length + 1];
        answer = new String[tickets.length + 1];
        result[0] = "ICN";
        dfs("ICN", 1);
              
        return answer;
    }
    
    static void dfs(String now, int idx) {
        if (finish) {
            return;
        }
        
        if (idx == result.length) {
            for (int i = 0; i < result.length; i++) {
                answer[i] = result[i];
            }
            finish = true;
            
            return;
        }
        
        if (!map.containsKey(now))
            return;
        
        ArrayList<String> nextList = map.get(now);
        boolean[] visitCheck = visited.get(now);
        
        for (int i = 0; i < nextList.size(); i++) {
            if (!visitCheck[i]) {
                visitCheck[i] = true;
                visited.put(now, visitCheck);
                result[idx] = nextList.get(i);
                
                dfs(nextList.get(i), idx + 1);
                
                visitCheck[i] = false;
                visited.put(now, visitCheck);
            }
        }
    }
}
import java.util.*;

class Solution {
    static int n;
    static Map<String, Map<Integer, Integer>> map;
    static int[][] sDice;
    public int[] solution(int[][] dice) {
        sDice = dice;
        n = dice.length;
        map = new HashMap<>();
        comb(0, "");
        
        List<String> keyA = new ArrayList<>(map.keySet());
        List<String> keyB = new ArrayList<>();

        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        for(String key : keyA){
            Arrays.fill(visited, false);
            sb.setLength(0);
            
            for(int i=0; i<key.length(); i++){
                visited[key.charAt(i)-'0'] = true;
            }
            
            for(int i=0; i<n; i++){
                if(!visited[i]) sb.append(i);
            }
            keyB.add(sb.toString());
        }
        
        int max = 0;
        int[] ans = new int[n/2];
        for(int i=0; i<keyA.size(); i++){
            String a = keyA.get(i);
            String b = keyB.get(i);
            List<Integer> sumA = new ArrayList<>(map.get(a).keySet());
            List<Integer> sumB = new ArrayList<>(map.get(b).keySet());
            
            int win = 0;
            int lose = 0;
            for(int aa : sumA){
                for(int bb : sumB){
                    if(aa > bb){
                        win += map.get(a).get(aa) * map.get(b).get(bb);
                    }
                }
            }
            
            if(win > max){
                max = win;
                for(int j=0; j<a.length(); j++){
                    ans[j] = (a.charAt(j) - '0') + 1;
                }
            }
        }
        
        return ans;
    }
    
    static void saveScore(int idx, int sum, String str){
        if(idx == str.length()){
            map.get(str).put(sum, map.get(str).getOrDefault(sum, 0) + 1);
            return;
        }
        
        for(int num : sDice[str.charAt(idx)-'0']){
            saveScore(idx+1, sum+num, str);
        }
    }
    
    
    static void comb(int start, String str){
        if(str.length() == n/2){
            map.put(str, new HashMap<>());
            saveScore(0, 0, str);
            return;
        }
        
        for(int i=start; i<n; i++){
            comb(i+1, str+i);
        }
    }
}

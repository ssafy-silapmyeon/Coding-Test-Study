import java.util.*;

class PGS_보석_쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int sort = set.size();

        Map<String, Integer> map = new HashMap<>();

        int cnt = 0;
        int p = 0;
        int[] ans = {0,0};
        int min = Integer.MAX_VALUE;
        for(int i=0; i<gems.length; i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i], 1);
                cnt++;
            }else{
                map.put(gems[i], map.get(gems[i]) + 1);
            }

            if(cnt == sort){
                while(map.get(gems[p]) > 1){
                    map.put(gems[p], map.get(gems[p]) - 1);
                    p++;
                }

                if(min > i - p){
                    min = i - p;
                    ans[0] = p + 1;
                    ans[1] = i + 1;
                }
            }
        }

        return ans;
    }
}
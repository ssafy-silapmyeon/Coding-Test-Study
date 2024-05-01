import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        int idx = 0;
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                idx = i;
            }else if(s.charAt(i) == '}'){
                list.add(s.substring(idx+1, i).split(","));
            }
        }
        
        Collections.sort(list, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                return o1.length - o2.length;
            }
        });
        
        int[] answer = new int[list.size()];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<list.size(); i++){
            for(String str : list.get(i)){
                int num = Integer.parseInt(str);
                if(!set.contains(num)){
                    answer[i] = num;
                }
                set.add(num);
            }
        }
    
        return answer;
    }
}

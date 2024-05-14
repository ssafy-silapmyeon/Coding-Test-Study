import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s,"{|}");
        int n = st.countTokens();
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            String t = st.nextToken();
            if(t.equals(",")){
                continue;
            }
            else{
                list.add(t);
            }
        }
        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
        for(String l:list){
            st = new StringTokenizer(l,",");
            n = st.countTokens();
            for(int i=0;i<n;i++){
                String num = st.nextToken();
                if(!set.contains(num)){
                    set.add(num);
                    result.add(num);
                }
            }
        }
        int[] answer = new int[result.size()];
        int idx =0;
        for(String r:result){
            int num = Integer.parseInt(r);
            answer[idx++] = num;
        }
        
        return answer;
    }
}
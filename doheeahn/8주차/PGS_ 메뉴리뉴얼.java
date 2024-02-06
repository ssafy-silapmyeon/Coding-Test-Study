import java.util.*;
class Solution {
    static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new LinkedList<>();
        
        for(int i=0;i<course.length;i++){//course
            map = new HashMap<>();
            for(int j=0;j<orders.length;j++){//orders
                int n = orders[j].length();
                char[] arr = new char[n];
                for(int k =0;k<n;k++){
                    arr[k] = orders[j].charAt(k);
                }
                Arrays.sort(arr);
                boolean[] visited = new boolean[n];
                comb(arr,visited,course[i],0,0);
            }
            int max =0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = max<entry.getValue() ? entry.getValue():max;
            }
            if(max <2){
                continue;
            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue()==max){
                    list.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));
        answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public void comb(char[] arr, boolean[] visited, int c,int cnt, int s){
        if(c==cnt){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    sb.append(arr[i]);
                }
            }
            if(map.containsKey(sb.toString())){
                int n = map.get(sb.toString());
                map.put(sb.toString(),n+1);
            }
            else{
                map.put(sb.toString(),1);
            }
            return;
        }
        for(int i=s;i<arr.length;i++){
            visited[i] = true;
            comb(arr,visited, c,cnt+1,i+1);
            visited[i] = false;
        }
    }
}
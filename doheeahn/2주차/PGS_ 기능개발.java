import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            int p = 100 - progresses[i];
            p = p%speeds[i]!=0 ? p/speeds[i]+1 : p/speeds[i];
            queue.offer(p);
        }
        
        int cnt =1;
        while(!queue.isEmpty()){
            int first = queue.poll();
            int n = queue.size();
            cnt =1;
            
            for(int i=0;i<n;i++){
                if(queue.peek()>first){
                    list.add(cnt);
                    break;
                }
                queue.poll();
                cnt++;
            }
        }
        list.add(cnt);
        
        
        int[] answer = new int[list.size()];
        int j=0;
        for(int i:list){
            answer[j] =i;
            j++;
        }
        

        
        
        return answer;
    }
}
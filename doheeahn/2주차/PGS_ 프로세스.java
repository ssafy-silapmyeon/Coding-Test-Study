import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        
        for(int i=0;i<priorities.length;i++){
            queue.offer(i);
            pq.offer(priorities[i]);
        }
        

        while(queue.size() !=0){
            int cur = queue.poll();
            if(priorities[cur] == pq.peek()){
                pq.poll();
                answer++;
                if(location == cur){
                    break;
                }
            }
            else{
                queue.offer(cur);
            }
            
        }
        
        
        return answer;
    }
}
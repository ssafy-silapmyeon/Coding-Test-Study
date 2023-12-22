import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum =0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length;i++){
            if(queue.size()== bridge_length){
                    sum -= queue.poll();
                }
            while(queue.size() < bridge_length){
                answer++;
                if(sum + truck_weights[i]<=weight){
                    queue.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    break;
                }
                else{
                    queue.offer(0);
                }
                
                if(queue.size()== bridge_length){
                    sum -= queue.poll();
                }
            }

        }
        return answer+bridge_length;
    }
}
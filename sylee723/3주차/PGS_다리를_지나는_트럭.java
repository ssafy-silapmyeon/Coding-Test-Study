import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Truck> bridge = new ArrayDeque<>();
        int time = 1;
        int total = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            while ((!bridge.isEmpty() && bridge.peek().arriveTime <= time) || (total + truck_weights[i] > weight)) {
                Truck arrive = bridge.poll();
                total -= arrive.weight;
                time = arrive.arriveTime;
            }
            
            total += truck_weights[i];
            bridge.add(new Truck(truck_weights[i], time + bridge_length));
            time++;        
        }
        
        int answer = bridge.peekLast().arriveTime;
        return answer;
    }
    
    static class Truck {
        int weight, arriveTime;
        
        public Truck(int weight, int arriveTime) {
            this.weight = weight;
            this.arriveTime = arriveTime;
        }
    }
}
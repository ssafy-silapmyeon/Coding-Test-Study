class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int d_max = n;
        int p_max = n;
        int max_dist;
        long answer = 0;
        
        while (true) {   
            while (d_max > 0 && deliveries[d_max - 1] == 0) {
                d_max--;
            }
            while (p_max > 0 && pickups[p_max - 1] == 0) {
                p_max--;
            }
            
            max_dist = Math.max(d_max, p_max);
            
            if (max_dist == 0) {
                break;
            }
            
            answer += (max_dist * 2);
            
            moveBox(deliveries, d_max, cap);
            moveBox(pickups, p_max, cap);
        }
        
        return answer;
    }
    
    static void moveBox(int[] box, int dist, int cap) {
        int count = 0;
        int portion;
        for (int i = dist - 1; i >= 0; i--) {
            if (count + box[i] <= cap) {
                count += box[i];
                box[i] = 0;
            } else {
                portion = cap - count;
                count += portion;
                box[i] -= portion;
            }

            if (count == cap)
                return;
        }
    }
}
import java.util.*;

class PSG_야근_지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }

        while(n-- > 0){
            int max = pq.poll();
            if(max == 0) break;
            pq.add(max - 1);
        }

        long ans = 0;
        while(!pq.isEmpty()){
            ans += (long)Math.pow(pq.poll(), 2);
        }

        return ans;
    }
}
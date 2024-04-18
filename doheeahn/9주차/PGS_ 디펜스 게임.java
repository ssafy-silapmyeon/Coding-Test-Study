import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0;i<enemy.length;i++){
            pq.offer(enemy[i]);
            if(i!=0){
                enemy[i] += enemy[i-1];//여태까지 사용한 병사수
            }
            while(enemy[i]>n && k>0 && !pq.isEmpty()){
                enemy[i]-=pq.poll();
                k--;
            }
            if(enemy[i]>n){
                answer = i;
                return answer;
            }

        }
        answer = enemy.length;
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        long sum1 =0;
        long sum =0;
        int cnt =0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0;i<queue1.length;i++){
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum += queue1[i]+queue2[i];
        }
        if((sum)%2!=0){
            return -1;
        }
        sum = sum/2;
        while(true){
            if(cnt > queue1.length*4) return -1;
            if(sum1 == sum) break;
            else if(sum1 > sum){
                int n = q1.poll();
                sum1 -= n;
                q2.offer(n);
            }
            else{
                int n = q2.poll();
                sum1 += n;
                q1.offer(n);
            }
            cnt ++;
        }
        
        
        answer = cnt;
        return answer;
    }

}
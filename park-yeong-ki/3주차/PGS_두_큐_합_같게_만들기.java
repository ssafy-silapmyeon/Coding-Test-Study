import java.util.*;

class PGS_두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long s1 = 0;
        long s2 = 0;
        int len = queue1.length;

        for(int i=0; i<len; i++){
            q1.add(queue1[i]);
            s1 += queue1[i];
        }

        for(int i=0; i<len; i++){
            q2.add(queue2[i]);
            s2 += queue2[i];
        }

        int cnt = 0;
        while(cnt < 4*len){
            if(s1 < s2){
                int n = q2.poll();
                s2 -= n;
                q1.add(n);
                s1 += n;
            }else if(s1 > s2){
                int n = q1.poll();
                s1 -= n;
                q2.add(n);
                s2 += n;
            }else break;

            cnt++;
        }

        return cnt == 4*len ? -1 : cnt;
    }
}
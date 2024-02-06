import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i<=d;i=i+k){
            int y = (int)Math.sqrt((long)d*d - (long)i*i);//제곱 long으로 해줘야함
            answer += y/k +1;
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(o1,o2)->o1[0]-o2[0]);
        int s = targets[0][0];
        int e = targets[0][1];
        answer++;
        
        for(int i=0;i<targets.length;i++){
            if(targets[i][0]<e){
                s = targets[i][0];
                if(targets[i][1]<e){
                    e= targets[i][1];
                }
            }
            else{
                s = targets[i][0];
                e = targets[i][1];
                answer++;
            }
        }

        
        
        return answer;
    }
}
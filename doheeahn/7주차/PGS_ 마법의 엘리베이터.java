class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey >0){
            int d = storey/10;
            int m = storey%10;
            
            if(m>5){
                storey = d+1;
                answer += (10-m);
            }
            else if(m<5){
                storey = d;
                answer +=m;
            }
            else{
                if((d%10)>=5){
                    storey = d+1;
                    answer +=(10-m);
                }
                else{
                    storey = d;
                    answer += m;
                }
            }
        }
        return answer;
    }
}
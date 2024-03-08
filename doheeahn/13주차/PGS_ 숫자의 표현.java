class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+i;
        }
        int s = n-1;
        int e = n;
        
        while(s >=0){
            if(sum[e]-sum[s]==n){
                answer++;
                e--;
                s--;
            }
            else if(sum[e]-sum[s]>n){
                e--;
            }
            else{
                s--;
            }
            
        }
        
        return answer;
    }
}
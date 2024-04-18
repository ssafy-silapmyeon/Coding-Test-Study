class Solution {
    public long solution(int[] sequence) {
        long sum1 = 0;
        long sum2 = 0;
        int flag = -1;
        long ans = Long.MIN_VALUE;
        for(int i=0; i<sequence.length; i++){
            sum1 += sequence[i] * flag;
            sum2 -= sequence[i] * flag;
            flag *= -1;
            
            if(sum1 < 0) sum1 = 0;
            if(sum2 < 0) sum2 = 0;
            
            ans = Math.max(ans, Math.max(sum1, sum2));
        }
        
        return ans;
    }
}

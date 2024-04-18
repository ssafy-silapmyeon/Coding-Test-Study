class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        boolean[] arr = new boolean[1000001];
        int[] sum = new int[elements.length+1];
        for(int i=1;i<sum.length;i++){
            sum[i] = elements[i-1]+sum[i-1];
        }
        
        for(int i=1;i<sum.length;i++){
            for(int j=1;j<sum.length;j++){
                int s=0;
                if(i>j){
                    s = sum[sum.length-1] - (sum[i-1]- sum[j]);

                }
                else{
                    s = sum[j] - sum[i-1];
                }
                if(!arr[s]){
                    arr[s] = true;
                    answer++;
                }  
            }
        }
        
        return answer;
    }
}
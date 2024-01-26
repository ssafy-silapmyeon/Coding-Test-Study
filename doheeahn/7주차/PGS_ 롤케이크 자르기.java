class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int type =0;
        int ctype =0;
        int sum[] = new int[10001];
        boolean[] check = new boolean[10001];
        
        for(int i=0;i<n;i++){
            if(sum[topping[i]]==0){
                type++;
            }
            sum[topping[i]]++;
        }
        for(int i=0;i<n;i++){
            if(!check[topping[i]]){
                ctype++;
                check[topping[i]] = true;
            }
            sum[topping[i]]--;
            if(sum[topping[i]]==0){
                type--;
            }
            if(type == ctype){
                answer++;
            }
            
        }
        return answer;
    }
}
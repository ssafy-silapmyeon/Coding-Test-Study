class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] idx = new int[n];
        int[] answer = new int[n];
        answer[n-1] = -1;
        
        for(int i=n-2;i>=0;i--){
            if(numbers[i]<numbers[i+1]){
                idx[i]=i+1;
                answer[i] = numbers[i+1];
            }
            else{
                int next = idx[i+1];
                while(true){
                    if(next ==0){
                        answer[i]=-1;
                        break;
                    }
                    if(numbers[i]<numbers[next]){
                        idx[i] = next;
                        answer[i] = numbers[next];
                        break;
                    }
                    else{
                        next = idx[next];
                    }
                }
            }
        }
        return answer;
    }
}
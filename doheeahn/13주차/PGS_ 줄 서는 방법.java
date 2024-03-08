class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];
        long cnt = 1;
        for(int i=1;i<n;i++){
            cnt*=i; 
        }
        long sum = 0;
        int idx = 0;
        
        while(idx<n-1){ //answer[idx] n-1까지 가야함
            for(int i=0;i<n-idx;i++){
                if(sum + (cnt *i)+1 <=k && sum +(cnt *(i+1))+1 > k){
                    int num = findNum(i+1,visited);
                    answer[idx] = num;
                    idx++;
                    sum += cnt *i;
                    cnt /= (n-idx);

                    break;
                }
            }
        }
        answer[idx] = findNum(1,visited);
        return answer;
    }
    public int findNum(int idx, boolean[] visited){
        
        int cnt =1;
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                continue;
            }
            if(cnt == idx){
                visited[i] =true;
                return i+1;
            }
            cnt++;
        }
        
        return cnt;
    }
}
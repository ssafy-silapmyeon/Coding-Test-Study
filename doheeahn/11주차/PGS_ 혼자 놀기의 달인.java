class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int[] visited = new int[cards.length];
        int num =0;
        int[] max = new int[2];
        
        for(int i=0;i<cards.length;i++){
            if(visited[i]!=0){
                continue;
            }
            visited[i] = 1;
            num = dfs(cards,visited,cards[i],1);
            if(max[0] < num || max[1] <num){
                if(max[0]>max[1]){
                    max[1] = num;
                }
                else{
                    max[0] = num;
                }
            }
        }
        answer = max[0] * max[1];
        return answer;
    }
    public int dfs(int[] cards, int[] visited, int num, int cnt){
        //num번째 부터 dfs visited가 0이 아닐때 까지
        if(visited[num-1]!=0){
            return cnt;
        }
        visited[num-1] = cnt+1;
        num = cards[num-1];
        return dfs(cards,visited,num,cnt+1);
    }
}
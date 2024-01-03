class Solution {
    static int result =0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        perm(k,dungeons,visited,0,0);
        
        answer = result;
        return answer;
    }
    
    public void perm(int k, int[][] dungeons, boolean[] visited,int cnt,int max){
        if(cnt == dungeons.length){
            if(result < max){
                result = max;
            }
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(dungeons[i][0]>k){
                perm(k,dungeons,visited,cnt+1,max);
            }
            else{
                perm(k-dungeons[i][1],dungeons,visited,cnt+1,max+1);
            }
            visited[i] = false;
        }
    }
}
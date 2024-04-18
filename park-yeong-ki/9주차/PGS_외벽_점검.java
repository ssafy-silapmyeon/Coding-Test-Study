class Solution {
    static int[] pArr, dArr, wArr;
    static int N, ans;
    static boolean[] visited;
    
    public int solution(int n, int[] weak, int[] dist) {
        dArr = dist;
        wArr = weak;
        N = n;
        
        pArr = new int[dist.length];
        visited = new boolean[dist.length];
        ans = Integer.MAX_VALUE;
        perm(0);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    static void perm(int idx){
        if(idx == pArr.length){
            for(int i=0; i<wArr.length; i++){
                int j = i;
                int cnt = 0;
                int range = -1;
                int current;
                boolean flag = true;
                while(j < i + wArr.length){
                    if(j < wArr.length){
                        current = wArr[j];
                    }else{
                        current = wArr[j%wArr.length] + N;
                    }
                    
                    if(current > range){
                        if(cnt >= pArr.length){
                            flag = false;
                            break;
                        }
                        
                        range = current + pArr[cnt];
                        cnt++;
                    }
                    
                    j++;
                }
                
                if(flag){
                    ans = Math.min(ans, cnt);
                }
            }
            
            return;
        }
        
        for(int i=0; i<dArr.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            pArr[idx] = dArr[i];
            perm(idx+1);
            visited[i] = false;
        }
    }
}

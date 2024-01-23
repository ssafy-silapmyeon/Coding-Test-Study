import java.util.*;

class Solution {
    static int[] ryan, apeach, ans;
    static int max;
    static boolean flag;
    public int[] solution(int n, int[] info) {
        ryan = new int[11];
        apeach = info;
        max = 0;
        ans = new int[]{-1};
        
        dfs(0, n);
        
        return ans;
    }
            
    static void dfs(int idx, int cnt){
        if(idx == 10){
            ryan[idx] = cnt;
            
            int a = 0;
            int r = 0;
            boolean flag = false;
            for(int i=0; i<=10; i++){
                if(max > 0){
                    if(ans[i] < ryan[i]) flag = true;
                    else if(ans[i] > ryan[i]) flag = false;
                }
                
                if(apeach[i] == 0 && ryan[i] == 0) continue;
                if(apeach[i] < ryan[i]) r += 10 - i;
                else a += 10 - i;
            }
            
            if(max < r - a){
                max = r - a;
                ans = ryan.clone();
            }else if(max == r - a && flag){
                ans = ryan.clone();
            }
            
            return;
        }
        
        for(int i=0; i<=cnt; i++){
            ryan[idx] = i;
            dfs(idx+1, cnt-i);
            ryan[idx] = 0;
        }
    }
}

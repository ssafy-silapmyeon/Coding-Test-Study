import java.util.*;

class Solution
{
    static int[][] memo;
    static String str;
    
    public int solution(String s)
    {
        str = s;
        memo = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            Arrays.fill(memo[i], -1);
            memo[i][i] = 1;
        }
    
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                ans = Math.max(ans, recursion(i, j));
            }
        }
        
        return ans;
    }
    
    static int recursion(int start, int end){        
        if(memo[start][end] != -1){
            return memo[start][end];
        }else{
            if(str.charAt(start) == str.charAt(end)){
                memo[start][end] = 2;
            }else{
                memo[start][end] = 0;
                return memo[start][end];
            }
        }
        
        if(start+1 <= end-1){
            int next = recursion(start+1, end-1);
            if(next == 0){
                memo[start][end] = 0;
            }else{
                memo[start][end] += next;
            }
        }
        
        return memo[start][end];
    }
}

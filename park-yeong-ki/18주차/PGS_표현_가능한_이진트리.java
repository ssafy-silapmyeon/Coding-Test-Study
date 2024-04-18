class Solution {
    static String str;
    static boolean flag;
    public int[] solution(long[] numbers) {
        int[] ans = new int[numbers.length];
        
        int[] len = {63, 31, 15, 7, 3, 1};
        int min;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            sb.append(Long.toBinaryString(numbers[i]));
            
            min = Integer.MAX_VALUE;
            for(int j=0; j<len.length; j++){
                if(len[j] - sb.length() >= 0){
                    min = Math.min(min, len[j] - sb.length());
                }
            }
            while(min-- > 0){
                sb.insert(0, "0");
            }
            
            str = sb.toString();
            sb.setLength(0);
            
            flag = true;
            dfs(0, str.length()-1, 1);
            
            ans[i] = flag ? 1 : 0;
        }
        
        return ans;
    }
    
    static void dfs(int start, int end, int parent){            
        int mid = (start + end) / 2;
        int child = str.charAt(mid) - '0';
        
        if(parent == 0 && child == 1){
            flag = false;
            return;
        }
    
        if(flag && start <= mid-1) dfs(start, mid-1, parent * child);
        if(flag && mid+1 <= end) dfs(mid+1, end, parent * child);
    }
}

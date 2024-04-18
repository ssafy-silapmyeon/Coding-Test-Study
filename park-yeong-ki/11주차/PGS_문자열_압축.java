class Solution {
    public int solution(String s) {
        int ans = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            String prev = "";
            String current;
            int cnt = 1;
            int len = s.length();
            for(int j=0; j+i<=s.length(); j+=i){
                current = s.substring(j, j+i);
                
                if(prev.equals(current)){
                    cnt++;
                }else{
                    if(cnt > 1){
                        len += String.valueOf(cnt).length();
                        len -= (cnt-1) * i;
                        cnt=1;
                    }
                }
                
                prev = current;
            }
            
            if(cnt > 1){
                len += String.valueOf(cnt).length();
                len -= (cnt-1) * i;
            }
            
            ans = Math.min(ans, len);
        }
        
        return ans;
    }
}

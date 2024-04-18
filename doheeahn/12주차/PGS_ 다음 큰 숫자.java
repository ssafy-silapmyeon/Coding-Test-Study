class Solution {
    public int solution(int n) {
        int answer = 0;
        String cur = Integer.toBinaryString(n);
        int cnt =count(cur);
        while(true){
            n++;
            String next = Integer.toBinaryString(n);
            int ncnt = count(next);
            if(cnt == ncnt){
                break;
            }
            
        }
        
        answer = n;
        return answer;
    }
    public int count(String s){
        int cnt =0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'0';
            if(c==1){
                cnt++;
            }
        }
        return cnt;
    }
}
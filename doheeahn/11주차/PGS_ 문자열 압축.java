class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<s.length();i++){//문자 단위
            String cur = s.substring(0,i);
            String result = "";
            int cnt =1;
            for(int j=i;j<=s.length()-i;j+=i){
                String com = s.substring(j,j+i);
                //같은 문자열
                if(cur.equals(com)){
                    cnt++;
                }
                //다른 문자열
                else{
                    if(cnt !=1){
                        result += Integer.toString(cnt);
                    }
                    result += cur;
                    cur = com;
                    cnt =1;
                }
                
                if(s.length() - (j+i) <i){
                    if(cnt !=1){
                        result += Integer.toString(cnt);
                    }
                    result += cur;
                    if(!(j+i == s.length())){
                        result += s.substring(j+i,s.length());
                    }       
                }
                
            }
            if(result.length() !=0 && answer > result.length()){
                answer = result.length();
            }
        }
        return answer;
    }
}
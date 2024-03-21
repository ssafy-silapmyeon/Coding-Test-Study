class Solution {
    public int[] solution(String s) {
        int cnt=0;
        int z=0;
        while(s.length()>1){
            cnt ++;
            int o=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    o++;
                }
                else{
                    z++;
                }
            }
            s = Integer.toBinaryString(o);
        }
        int[] answer = {cnt,z};
        return answer;
    }
}
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        //dlru
        int[] dir = new int[4];
        int cnt=k;//상쇄 시켜야 하는 거
        
        if(r-x>=0){
            dir[0] = r-x;
            cnt -= (r-x);
        }
        else{
            dir[3] = x-r;
            cnt -= (x-r);
        }
        if(c-y>=0){
            dir[2] = c-y;
            cnt -= (c-y);
        }else{
            dir[1] = y-c;
            cnt -= (y-c);
        }
        // 주어진k로 탈출 못할때, 쌍으로 상쇄가 안될때
        if(cnt <0 || cnt%2!=0){
            return "impossible";
        }
        cnt /=2;
        for(int i=0;i<k;i++){
            if((dir[0]>0 || cnt >0) && x <n){
                x++;
                answer +="d";
                if(dir[0]>0){
                    dir[0]--;
                }
                else{
                    cnt--;
                    dir[3]++;
                }
            }
            else if((dir[1]>0 || cnt >0) && y>1){
                y--;
                answer +="l";
                if(dir[1]>0){
                    dir[1]--;
                }
                else{
                    cnt--;
                    dir[2]++;
                }
            }
            else if((dir[2]>0|| cnt >0) && y<m){
                y++;
                answer +="r";
                if(dir[2]>0){
                    dir[2]--;
                }
                else{
                    cnt --;
                    dir[1]++;
                }
            }
            else{
                x--;
                answer +="u";
                if(dir[3]>0){
                    dir[3]--;
                }
                else{
                    cnt --;
                    dir[0]++;
                }
            }
        }

        return answer;
    }
}
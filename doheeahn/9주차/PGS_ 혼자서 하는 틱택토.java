class Solution {
    static int o=0;
    static int x=0;
    public int solution(String[] board) {
        int answer = 1;
        boolean count=false;
        char[][] arr = new char[3][3];
        o = 0;
        x = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = board[i].charAt(j);
                check(arr[i][j]);
            }
        }
        
        if(o<x || o-x>1){
            answer = 0;
            return answer;
        }
        if(o==x){
            count = true;
        }
        o=0;
        x=0;
        for(int i=0;i<3;i++){
            if(arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2]){
                check(arr[i][0]);
            }
            if(arr[0][i]==arr[1][i]&& arr[1][i]==arr[2][i]){
                check(arr[0][i]);
            }
        }
        
        if(arr[1][1]==arr[0][0] && arr[0][0]==arr[2][2]){
            check(arr[1][1]);
        }
        if(arr[1][1] == arr[0][2] && arr[0][2]==arr[2][0]){
            check(arr[1][1]);
            
        }
        if(o>0 && x>0){
            answer = 0;
        }
        else{
            if(count && o>x){
                answer = 0;
            }
            else if(!count && o<x){
                answer =0;
            }
        }
        return answer;
    }
    
    public void check(char c){
        if(c=='O'){
            o++;
        }
        else if(c=='X'){
            x++;
        }
    }
}
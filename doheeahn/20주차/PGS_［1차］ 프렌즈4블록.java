import java.util.*;
class Solution {
    static int[] di = {0,-1,-1};
    static int[] dj = {-1,-1,0};
    static int answer =0;
    static class Idx{
        int i,j;
        Idx(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int solution(int m, int n, String[] board) {
        boolean b = true;
        char[][] arr = new char[m][n];
        for(int i=0;i<m;i++){
            arr[i] = board[i].toCharArray();
        }
        
        while(b){
            b = false;
            int cur = answer;
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(arr[i][j] == '.' || ('a'<=arr[i][j] && arr[i][j]<='z')){
                        continue;
                    }
                    check(i,j,arr);
                    if(cur < answer){
                        answer++;
                        arr[i][j] = (char)(arr[i][j] +32);
                        b = true;
                        cur = answer;
                    }
                }
            }
            drop(arr);

        }
        return answer;
    }
    public void drop(char[][] arr){
        for(int i=arr[0].length-1;i>=0;i--){
            int cnt =0;
            for(int j = arr.length-1;j>=0;j--){
                if(arr[j][i] == '.'){
                    break;
                }
                if('a'<=arr[j][i] && arr[j][i]<='z'){
                    arr[j][i] = '.';
                    cnt++;
                }
                else if(cnt ==0){
                    continue;
                }
                else{
                    arr[j+cnt][i] = arr[j][i];
                    arr[j][i] = '.';
                }
                
            }
        }
    }
    public void check(int i, int j, char[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        LinkedList<Idx> list = new LinkedList<>();
        
        for(int d=0;d<3;d++){
            int r = i+di[d];
            int c = j+dj[d];
            if(r<0 || c <0){
                return;
            }
            if('A'<=arr[r][c] && arr[r][c]<='Z'){
                if(arr[r][c] == arr[i][j]){
                    list.add(new Idx(r,c));
                }
                else if(arr[r][c] == (char)(arr[i][j]-32)){
                    list.add(new Idx(r,c));
                }
                else{
                    return;
                }
            }
            else if('a'<=arr[r][c] && arr[r][c] <='z'){
                if(arr[r][c] == (char)(arr[i][j]+32)){
                    continue;
                }
                else if(arr[r][c] == arr[i][j]){
                    continue;
                } 
                else{
                    return;
                }
            }
            else{
                return;
            }
        }
        for(Idx idx:list){
            if('A'<=arr[idx.i][idx.j] && arr[idx.i][idx.j]<='Z'){
                answer ++;
                arr[idx.i][idx.j]= (char)(arr[idx.i][idx.j]+32);
            }
            
            check(idx.i,idx.j,arr);
            
        }
    }
}
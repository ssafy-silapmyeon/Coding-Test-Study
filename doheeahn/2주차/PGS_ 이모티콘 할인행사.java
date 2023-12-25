import java.util.*;
class Solution {
    static int nmax;
    static int pmax;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sale = new int[emoticons.length];
        com(users,emoticons,sale,0);
        int[] answer = {nmax,pmax};
        return answer;
    }
    
    
    public void com(int[][] users, int[] emoticons,int[] sale, int idx){
        if(idx == emoticons.length){ 
            int n=0;
            int p=0;
            for(int i=0;i<users.length;i++){
                int sum =0;
                for(int j=0;j<emoticons.length;j++){
                    if(users[i][0] <= sale[j]){
                        sum += emoticons[j]*(1 - sale[j]*0.01);
                    }
                }
                if(sum >= users[i][1]){
                    n++;
                }
                else{
                    p +=sum;
                }
            }
            if(nmax < n){
                nmax =n;
                pmax =p;
            }
            else if(nmax == n ){
                if(pmax < p){
                    pmax =p;
                }
            }
            return;
        }
        
        for(int i=1;i<5;i++){
            sale[idx] = i*10;
            com(users, emoticons,sale, idx+1);
        }
        
        
    }
}
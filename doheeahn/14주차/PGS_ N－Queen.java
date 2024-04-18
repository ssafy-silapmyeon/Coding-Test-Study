import java.util.*;
class Solution {
    static int answer=0;
    public int solution(int n) {
        int[] col = new int[n];
        
        queen(0,col); //0행 확인
        return answer;
    }
    
    public void queen(int r, int[] col){//행별로 확인
        if(r == col.length){//퀸 다 배치 했을 경우
            answer ++;
            return;
        }
        for(int i=0;i<col.length;i++){//모든 열을 확인
            if(isAvailable(r,col,i)){//해당 열에 놓을 수 있다면
                col[r] = i;
                queen(r+1,col);
                
            }
        }
    }
    
    public boolean isAvailable(int r, int[] col, int c){//퀸을 놓은 행,,열
        for(int i=0;i<r;i++){
            if(col[i] == c || Math.abs(r-i) == Math.abs(c-col[i])){
                return false;
            }
        }
        return true;
    }
}
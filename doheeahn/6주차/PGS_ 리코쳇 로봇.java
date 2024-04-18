import java.util.*;
class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static class Idx{
        int i,j;
        
        public Idx(int i, int j){
            this.i =i;
            this.j = j;
        }
    }
    public int solution(String[] board) {
        int answer = 0;
        Queue<Idx> queue = new LinkedList<>();
        char[][] arr = new char[board.length][board[0].length()];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                arr[i][j] = board[i].charAt(j);
                if(arr[i][j]=='R'){
                    queue.offer(new Idx(i,j));
                    arr[i][j] ='X';//이미 왔던 곳
                }
            }
        }
        
        while(!queue.isEmpty()){
            int n = queue.size();
            answer++;
            for(int t=0;t<n;t++){
                Idx cur = queue.poll();
                for(int d=0;d<4;d++){
                    int i = cur.i;
                    int j = cur.j;
                    while(i+di[d] >=0 && i+di[d]< board.length &&
                         j+dj[d] >=0 && j+dj[d] < board[0].length() &&
                         arr[i+di[d]][j+dj[d]] !='D'){
                        i+=di[d];
                        j+=dj[d];
                    }
                    if((i==cur.i && j==cur.j) || arr[i][j]=='X'){
                        continue;
                    }
                    else if(arr[i][j]=='G'){
                        return answer;
                    }
                    else{
                        arr[i][j] ='X';
                        queue.offer(new Idx(i,j));
                    }
                }
            }
        }
        return -1;
    }
}
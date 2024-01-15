import java.util.*;
class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static class Idx{
        int i,j;
        public Idx(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int solution(String[] maps) {
        int answer = 0;
        int r = maps.length;
        int c = maps[0].length();
        char[][] arr = new char[r][c];
        boolean pull = false;
        Queue<Idx> queue = new LinkedList<>();
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] =='S'){
                    queue.offer(new Idx(i,j));
                    arr[i][j] = 'P';
                }
            }
        }
        
        while(!queue.isEmpty() && !pull){
            answer++;
            int n = queue.size();
            for(int i=0;i<n;i++){
                Idx cur = queue.poll();
                for(int d=0;d<4;d++){
                    int ci = cur.i+di[d];
                    int cj = cur.j+dj[d];
                    if(ci >=0 && ci <r &&
                      cj >=0 && cj <c && arr[ci][cj] !='P' && arr[ci][cj] !='X'){
                        if(arr[ci][cj]=='L'){
                            pull = true;
                            queue = new LinkedList<>();
                            queue.offer(new Idx(ci,cj));
                            arr[ci][cj] ='X';
                            break;
                        }
                        else if(arr[ci][cj]=='E'){
                            queue.offer(new Idx(ci,cj));
                        }
                        else{
                            arr[ci][cj] = 'P';
                            queue.offer(new Idx(ci,cj));
                        }
                    }
                }
                if(pull){
                    break;
                }
            }
        }
        
        while(!queue.isEmpty()){
            answer++;
            int n = queue.size();
            for(int i=0;i<n;i++){
                Idx cur = queue.poll();
                for(int d=0;d<4;d++){
                    int ci = cur.i+di[d];
                    int cj = cur.j+dj[d];
                    if(ci >=0 && ci <r &&
                      cj >=0 && cj <c &&arr[ci][cj] !='X'){
                        if(arr[ci][cj]=='E'){
                            return answer;
                        }
                        else{
                            queue.offer(new Idx(ci,cj));
                            arr[ci][cj] ='X';
                        }
                    }
                }
            }
        }
        
        
        
        return -1;
    }
}
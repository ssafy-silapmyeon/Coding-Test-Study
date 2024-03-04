import java.util.*;
class Solution {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    
    static class Index{
        int i,j;
        public Index(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] arr = new char[5][5];
        
        for(int i=0;i<5;i++){//대기실
            for(int j=0;j<5;j++){
                arr[j] = places[i][j].toCharArray();
            }
            
            if(check(arr)){//거리두기 실패
                answer[i] = 0;
            }
            else{
                answer[i] =1;
            }
            
        }
        return answer;
    }
    
    public boolean check(char[][] arr){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){

                if(arr[i][j] == 'P'){
                    Queue<Index> queue = new LinkedList<>();
                    int si = i;
                    int sj = j;
                    queue.offer(new Index(i,j));
                
                    int cnt=0;
                    while(!queue.isEmpty() && cnt <2){
                        int num = queue.size();
                        cnt++;
                        for(int n=0;n<num;n++){
                            Index cur = queue.poll();
                            for(int d =0;d<4;d++){
                                int x = cur.i+di[d];
                                int y = cur.j+dj[d];
                                if(x>=0 && x<5 && y>=0 && y<5 &&
                                    !(x ==si && y==sj) && arr[x][y]!='X'){
                                    if(arr[x][y]=='P'){
                                        return true;
                                    }
                                    queue.offer(new Index(x,y));
                                }
                            }
                        }
                    }   
                }
            }
        }
        return false;
    }
}
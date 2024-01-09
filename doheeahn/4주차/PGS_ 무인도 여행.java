import java.util.*;
class Solution {
    static class Idx{
        int i,j;
        
        public Idx(int i,int j){
            this.i =i;
            this.j = j;
        }
    }
    
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    public int[] solution(String[] maps) {
        int[][] map = new int[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[i].length();j++){
                map[i][j] = maps[i].charAt(j)-'0';
                
            }
        }
        
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                int r = bfs(map,i,j);
                if(r!=0){
                    list.add(r);
                }
            }
        }
        Collections.sort(list);
        int[] answer={};
        if(list.size()==0){
            answer = new int[1];
            answer[0]=-1;
        }
        else{
            answer = new int[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    
    public int bfs(int[][] map,int i,int j){
        int sum =0;
        Queue<Idx> queue = new LinkedList<>();
        if(map[i][j]>=1 && map[i][j]<=9){
            queue.offer(new Idx(i,j));
            sum += map[i][j];
            map[i][j] =0;
        }
        
        while(!queue.isEmpty()){
            
            int num = queue.size();
            for(int n=0;n<num;n++){
                Idx cur = queue.poll();
                
                for(int d=0;d<4;d++){
                    int x = cur.i+di[d];
                    int y = cur.j+dj[d];
                    
                    if(x>=0 && x < map.length 
                      && y>=0 && y<map[0].length && map[x][y] >=1 && map[x][y]<=9){
                        sum += map[x][y];
                        map[x][y] =0;
                        queue.offer(new Idx(x,y));
                    }
                }
            }
        }
        return sum;
    }
}
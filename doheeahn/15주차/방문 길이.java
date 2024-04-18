import java.util.*;
class Solution {
    static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    static int[] dir = {1,2,4,8};
    static HashMap<String,Idx> map =new HashMap<>();
    
    static class Idx{
        int i,j,v;
        public Idx(int i, int j,int v){
            this.i =i;
            this.j =j;
            this.v =dir[v];
        }
    }
    
    public int solution(String dirs) {
        int curi =0;
        int curj =0;
        int answer =0;
        for(int i=0;i<dirs.length();i++){
            switch(dirs.charAt(i)){
                case 'U':
                    if(curi+di[0] >=-5 && curi+di[0]<=5 && curj+dj[0] >=-5 && curj+dj[0] <=5){
                        if(visited(curi,curj,0)){
                            answer++;
                            visited(curi+di[0],curj+dj[0],2);
                        }
                        curi += di[0];
                        curj += dj[0];
                    }
                    break;
                case 'R':
                    if(curi+di[1] >=-5 && curi+di[1]<=5 && curj+dj[1] >=-5 && curj+dj[1] <=5){
                        if(visited(curi,curj,1)){
                            answer++;
                            visited(curi+di[1],curj+dj[1],3);
                        }
                        curi += di[1];
                        curj += dj[1];
                    }
                    break;
                case 'D':
                    if(curi+di[2] >=-5 && curi+di[2]<=5 && curj+dj[2] >=-5 && curj+dj[2] <=5){
                        if(visited(curi,curj,2)){
                            answer++;
                            visited(curi+di[2],curj+dj[2],0);
                        }
                        curi += di[2];
                        curj += dj[2];
                    }
                    break;
                case 'L':
                    if(curi+di[3] >=-5 && curi+di[3]<=5 && curj+dj[3] >=-5 && curj+dj[3] <=5){
                        if(visited(curi,curj,3)){
                            answer++;
                            visited(curi+di[3],curj+dj[3],1);
                        }
                        curi += di[3];
                        curj += dj[3];
                    }
                    break;
            }
        }
        
        
        return answer;
    }
    public boolean visited(int curi,int curj,int d){
        String cur = Integer.toString(curi)+Integer.toString(curj);
        
        if(map.containsKey(cur)){
            Idx node= map.get(cur);
            if((node.v & dir[d])==0){//최초 방문
                node.v += dir[d];
                return true;
            }
        }
        else{//최초 방문
            map.put(cur,new Idx(curi,curj,d));
            return true;  
        }
        return false;
    }
}
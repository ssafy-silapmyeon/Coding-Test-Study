import java.util.*;
class Solution {
    static LinkedList<Integer> list = new LinkedList<>(); //후보키 저장
    public int solution(String[][] relation) {
        int answer = 0;
        int c = relation[0].length;
        
        for(int i=1;i<=c;i++){
            com(i,0,0,new boolean[c],relation);
        }
        answer = list.size();
        return answer;
    }
    public void com(int n,int cnt,int s,boolean[] visited,String[][] relation){
        if(n==cnt){
            
            //최소성 확인
            if(!mini(visited)){
                return;
            }
            //유일성 확인
            check(visited, relation,n);
            return;
        }
        
        for(int i=s;i<visited.length;i++){
            visited[i] = true;
            com(n,cnt+1,i+1,visited,relation);
            visited[i] = false;
        }
    }
    public boolean mini(boolean[] visited){
        String st="";
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                st+="1";
            }
            else{
                st+="0";
            }
        }
        
        for(int l: list){
            if((l & Integer.parseInt(st,2)) ==l){
                return false;
            }
        }
        return true;
    }
    
    public void check(boolean[] visited,String[][] relation,int n){
        
        for(int i=0;i<relation.length-1;i++){
            for(int j=i+1;j<relation.length;j++){
                int cnt=0;
                for(int k=0;k<visited.length;k++){
                    if(visited[k]){
                        if(relation[i][k].equals(relation[j][k])){
                            cnt++;
                        }
                    }
                }
                if(cnt == n){
                    return;
                }
            }
        }
        
        String st = "";
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                st +="1";
            }
            else{
                st +="0";
            }
        }
        list.add(Integer.parseInt(st,2));
        return;
    }
}
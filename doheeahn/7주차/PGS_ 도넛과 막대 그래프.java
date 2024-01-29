import java.util.*;
class Solution {
    static int[] answer;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        LinkedList<Integer>[] list = new LinkedList[1000001];
        int v=0;
        boolean[] visited = new boolean[1000001];
        for(int i=0;i<1000001;i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            list[edges[i][0]].add(edges[i][1]);
            if(!visited[edges[i][1]]){
                visited[edges[i][1]] = true;
            }
        }
        for(int i=1;i<1000001;i++){//정점 찾기
            if(list[i].size() >1 && !visited[i]){
                v=i;
                answer[0] = v;
                break;
            }    
        }

        for(int i: list[v]){
            dfs(i,list,0);
        }
        
        return answer;
    } 
    public void dfs(int v, LinkedList[] list, int s){
        if(list[v].size()==2){
            answer[3]++;
            return;
        }
        else if(v==s){
            answer[1]++;
            return;
        }
        
        else if(list[v].size()==0){
            answer[2]++;
            return;
        }
        
        if(s==0){
            s=v;
        }
        dfs((int)list[v].peek(),list,s);
    }
}
import java.util.*;

class Solution {
    static ArrayList<Integer>[] adjList;
    static int[] sInfo;
    static int answer;
    
    public int solution(int[] info, int[][] edges) {
        sInfo = info;
        adjList = new ArrayList[info.length];
        for(int i=0; i<adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            adjList[e[0]].add(e[1]);
        }
        
        answer = 0;
        dfs(0, sInfo[0] ^ 1, sInfo[0], new ArrayList<>(adjList[0]));
    
        return answer;
    }
    
    static void dfs(int cur, int sheep, int wolf, List<Integer> nodes){
        if(sheep <= wolf){
            return;
        }
        answer = Math.max(answer, sheep);
        
        for(int i=0; i<nodes.size(); i++){
            int next = nodes.get(i);
            nodes.remove(i);
            for(int j=0; j<adjList[next].size(); j++){
                nodes.add(adjList[next].get(j));
            }
            dfs(next, sheep + (sInfo[next] ^ 1), wolf + sInfo[next], nodes);
            for(int j=0; j<adjList[next].size(); j++){
                nodes.remove(nodes.size()-1);
            }
            nodes.add(i, next);
        }
    }
}

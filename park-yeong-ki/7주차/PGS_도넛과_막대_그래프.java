import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] outDegree;
    static int[] inDegree;
    static int N;
    public int[] solution(int[][] edges) {
        N = 0;
        int a, b;
        for(int i=0; i<edges.length; i++){
            a = edges[i][0];
            b = edges[i][1];
            N = Math.max(N, Math.max(a, b));
        }
        
        outDegree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            outDegree[i] = new ArrayList<>();
        }
        
        inDegree = new int[N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<edges.length; i++){
            a = edges[i][0];
            b = edges[i][1];
            outDegree[a].add(b);
            inDegree[b]++;
        }
        
        int newNode = 0;
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0 && outDegree[i].size() >= 2){
                newNode = i;
                break;
            }
        }
        
        visited[newNode] = true;
        for(int next : outDegree[newNode]){
            inDegree[next]--;
        }
        
        int[] ans = new int[4];
        ans[0] = newNode;
        
        int graph8 = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(inDegree[i] == 2 && outDegree[i].size() == 2){
                dfs(i);
                graph8++;
            }
        }
        ans[3] = graph8;

        int bar = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(inDegree[i] == 0 && (outDegree[i].size() == 0 || outDegree[i].size() == 1)){
                dfs(i);
                bar++;
            }
        }
        ans[2] = bar;
        
        int donut = 0;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            dfs(i);
            donut++;
        }
        ans[1] = donut;
        
        return ans;
    }
    
    static void dfs(int num){
        if(visited[num]) return;
        visited[num] = true;
        
        for(int next : outDegree[num]){
            dfs(next);
        }
    }
}

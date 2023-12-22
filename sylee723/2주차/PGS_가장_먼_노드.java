import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }
        
        int answer = bfs(adjList, n);
        return answer;
    }
    
    static int bfs(ArrayList<Integer>[] adjList, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        
        visited[1] = true;
        queue.add(1);
        
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int s = 0; s < size; s++) {
                int now = queue.poll();
                
                for (int next : adjList[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        
        return size;
    }
}
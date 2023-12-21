import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(visited, computers, i, n);
            }
        }
        return answer;
    }
    
    static void bfs(boolean[] visited, int[][] computers, int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < n; i++) {
                if (computers[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
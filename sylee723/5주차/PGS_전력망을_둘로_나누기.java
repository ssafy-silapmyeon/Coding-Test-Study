import java.util.*;

class Solution {
    static int answer;
    
    public int solution(int n, int[][] wires) {
        boolean[][] adjArr = new boolean[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            adjArr[v1][v2] = true;
            adjArr[v2][v1] = true;
        }
        
        answer = n;
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            adjArr[v1][v2] = false;
            adjArr[v2][v1] = false;
            
            bfs(n, 1, adjArr);
            
            adjArr[v1][v2] = true;
            adjArr[v2][v1] = true;
        }
        
        return answer;
    }
    
    static void bfs(int n, int start, boolean[][] w) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(start);
        visited[start] = true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            count++;
            
            for (int i = 1; i <= n; i++) {
                if (w[now][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        
        answer = Math.min(answer, Math.abs(count - (n - count)));
    }
}
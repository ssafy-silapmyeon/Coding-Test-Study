import java.util.*;

class Solution {
    static ArrayList<Integer>[] win;
    static ArrayList<Integer>[] lose;
    public int solution(int n, int[][] results) {
        win = new ArrayList[n + 1];
        lose = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];
            
            win[A].add(B);
            lose[B].add(A);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = bfs(i);
            
            if (count == n) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[win.length];
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : win[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : lose[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        
        return count;
    }
}
import java.util.*;

class Solution {
    static int N, answer;
    static ArrayList<Integer>[] graph;
    static boolean[] wolf;
    static boolean[] visited; // 상태 방문 여부
    
    public int solution(int[] info, int[][] edges) {
        N = info.length; // 노드 개수
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int e = 0; e < edges.length; e++) {
            int p = edges[e][0];
            int c = edges[e][1];
            
            graph[p].add(c);
        }
        
        wolf = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (info[i] == 1) {
                wolf[i] = true;
            }
        }
        
        visited = new boolean[1 << N];
        answer = 0;
        dfs(1);
        
        return answer;
    }
    
    static void dfs(int state) {
        if (visited[state]) {
            return;
        }
        
        visited[state] = true;
        int sheepCnt = 0;
        int wolfCnt = 0;
        
        // state에 대해 양, 늑대가 각각 몇마리인지 구하기
        for (int i = 0; i < N; i++) {
            if ((state & (1 << i)) > 0) {
                if (wolf[i]) {
                    wolfCnt++;
                } else {
                    sheepCnt++;
                }
            }
        }
        
        if (sheepCnt <= wolfCnt) { // 방문할 수 없는 상태인 경우
            return;
        }
        
        answer = Math.max(answer, sheepCnt);
        
        for (int i = 0; i < N; i++) {
            if ((state & (1 << i)) == 0) { // state가 i번 노드 갖고 있지 않는 경우
                continue;
            }
            
            for (int next : graph[i]) {
                dfs(state | (1 << next));
            }
        }
    }
}
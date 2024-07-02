import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        ArrayList<Integer>[] adjListR = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
            adjListR[i] = new ArrayList<>();
        }

        int from, to;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjListR[to].add(from);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[4][n+1];
        visited[0][T] = true;
        bfs(S, T, adjList, visited[0]);
        bfs(T, S, adjListR, visited[1]);

        visited[2][S] = true;
        bfs(T, S, adjList, visited[2]);
        bfs(S, T, adjListR, visited[3]);

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(i == S || i == T) continue;
            if(visited[0][i] && visited[1][i] && visited[2][i] && visited[3][i]){
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void bfs(int start, int end, ArrayList<Integer>[] list, boolean[] visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        int cur;
        while(!queue.isEmpty()){
            cur = queue.poll();

            for(int next : list[cur]){
                if(visited[next]) continue;
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Video>[] adjList;
    static class Video{
        int to, usado;

        public Video(int to, int usado) {
            this.to = to;
            this.usado = usado;
        }
    }

    static int k, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }

        int p, q, r;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            adjList[p].add(new Video(q, r));
            adjList[q].add(new Video(p, r));
        }

        int v;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            cnt = -1;
            dfs(v, Integer.MAX_VALUE, new boolean[N + 1]);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int v, int min, boolean[] visited) {
        if (min >= k){
            cnt++;
        }

        visited[v] = true;

        for (Video next : adjList[v]) {
            if (visited[next.to]) continue;
            dfs(next.to, Math.min(min, next.usado), visited);
        }
    }
}

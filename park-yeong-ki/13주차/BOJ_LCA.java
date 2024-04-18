import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] depth;
    static ArrayList<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int from, to;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        dfs(1, 0);

        int M = Integer.parseInt(br.readLine());
        int a, b;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(lca(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    static int lca(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] < depth[b]) {
                b = parent[b];
            } else {
                a = parent[a];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void dfs(int current, int p) {
        for (int next : adjList[current]) {
            if (next == p) continue;
            parent[next] = current;
            depth[next] = depth[current] + 1;
            dfs(next, current);
        }
    }
}

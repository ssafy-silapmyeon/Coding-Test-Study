import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        int t, w;

        public Edge(int t, int w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static ArrayList<Edge>[] adjList;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        int from, to, weight;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, weight));
            adjList[to].add(new Edge(from, weight));
        }

        System.out.println(dijkstra(1, N));
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        pq.add(new Edge(start, 0));

        Edge current;
        while (!pq.isEmpty()) {
            current = pq.poll();

            if (current.t == end) {
                return current.w;
            }

            if (visited[current.t]) continue;
            visited[current.t] = true;

            for (Edge e : adjList[current.t]) {
                if (visited[e.t]) continue;
                pq.add(new Edge(e.t, e.w + current.w));
            }
        }

        return 0;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] adjList;
    static int n, min;
    static Map<Integer, List<Integer>> scoreMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int from, to;
        while (true) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            if (from == -1 && to == -1) {
                break;
            }

            adjList[from].add(to);
            adjList[to].add(from);
        }

        scoreMap = new HashMap<>();
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(scoreMap.get(min).size()).append("\n");
        for (int num : scoreMap.get(min)) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(start);
        visited[start] = true;

        int size;
        int score = 0;
        int current;
        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                current = queue.poll();

                for (int next : adjList[current]) {
                    if (visited[next]) continue;
                    queue.add(next);
                    visited[next] = true;
                }
            }

            score++;
        }

        if (!scoreMap.containsKey(score - 1)) {
            scoreMap.put(score - 1, new ArrayList<>());
        }
        scoreMap.get(score - 1).add(start);

        min = Math.min(min, score - 1);
    }
}

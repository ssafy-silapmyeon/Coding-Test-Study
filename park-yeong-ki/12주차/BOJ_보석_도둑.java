import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int w, v;

        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.v, this.v);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int M, V;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (!map.containsKey(M)) {
                map.put(M, new PriorityQueue<>(Collections.reverseOrder()));
            }
            map.get(M).add(V);
        }

        int[] bag = new int[K];
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
            if (bag[i] >= 1000000) bag[i] = 1000000;
        }

        Arrays.sort(bag);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long ans = 0;
        int prev = 0;
        Node current;
        for (int w : bag) {
            for (int i = prev; i <= w; i++) {
                if (!map.containsKey(i) || map.get(i).isEmpty()) continue;
                pq.add(new Node(i, map.get(i).poll()));
            }
            prev = w + 1;

            if (pq.isEmpty()) continue;
            current = pq.poll();
            ans += current.v;

            if (map.get(current.w).isEmpty()) continue;
            pq.add(new Node(current.w, map.get(current.w).poll()));
        }

        System.out.println(ans);
    }
}

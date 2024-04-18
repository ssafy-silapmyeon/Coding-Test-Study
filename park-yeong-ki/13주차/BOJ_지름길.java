import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, D;
    static class Road{
        int end, length;

        public Road(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }

    static Map<Integer, List<Road>> map;
    static List<Integer> sList;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int start, end, length;
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            map.get(start).add(new Road(end, length));
        }

        sList = new ArrayList<>(map.keySet());
        Collections.sort(sList);

        max = Integer.MIN_VALUE;
        dfs(0, 0, 0);

        System.out.println(D - max);
    }

    static void dfs(int idx, int dist, int prev) {
        if (idx == sList.size()) {
            max = Math.max(max, dist);
            return;
        }

        dfs(idx + 1, dist, prev);

        int start = sList.get(idx);
        if (prev <= start) {
            for (Road next : map.get(start)) {
                if (next.end > D) continue;
                dfs(idx + 1, dist + next.end - start - next.length, next.end);
            }
        }
    }
}

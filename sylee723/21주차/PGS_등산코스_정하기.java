import java.util.*;

class Solution {
    static ArrayList<Node>[] graph;
    static int[] type;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int p = 0; p < paths.length; p++) {
            int i = paths[p][0];
            int j = paths[p][1];
            int w = paths[p][2];
            
            graph[i].add(new Node(j, w));
            graph[j].add(new Node(i, w));
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], new Comparator<Node>() {
                @Override
                public int compare(Node n1, Node n2) {
                    return n1.time - n2.time;
                }
            });
        }
        
        type = new int[n + 1];
        for (int gate : gates) {
            type[gate] = 1;
        }
        for (int summit: summits) {
            type[summit] = 2;
        }
        
        int[] answer = { n + 1, Integer.MAX_VALUE };
        for (int s = 0; s < summits.length; s++) {
            int intensity = findRoute(summits[s], n);
            
            if (answer[1] > intensity) {
                answer[0] = summits[s];
                answer[1] = intensity;
            } else if (answer[1] == intensity) {
                answer[0] = Math.min(answer[0], summits[s]);
            }
        }
        
        return answer;
    }
    
    static public int findRoute(int summit, int n) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(summit, 0));
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[summit] = 0;
        
        int intensity = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (type[now.num] == 1) {
                intensity = Math.min(intensity, now.time);
                continue;
            }
            
            if (now.time >= intensity) {
                continue;
            }
            
            for (Node next : graph[now.num]) {
                if (type[next.num] == 2) {
                    continue;
                }
                
                int time = Math.max(now.time, next.time);
                if (time < visited[next.num]) {
                    visited[next.num] = time;
                    queue.add(new Node(next.num, time));
                }
            }
        }
        
        return intensity;
    }
    
    static class Node {
        int num, time;
        
        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
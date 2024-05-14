import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int n, i;
        
        Node(int n, int i){
            this.n = n;
            this.i = i;
        }
        
        @Override
        public int compareTo(Node o1){
            return this.i - o1.i;
        }
    }
    static ArrayList<Node>[] adjList;
    static Set<Integer> set;
    static int[] answer;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        adjList = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] p : paths){
            adjList[p[0]].add(new Node(p[1], p[2]));
            adjList[p[1]].add(new Node(p[0], p[2]));
        }
        
        set = new HashSet<>();
        for(int s : summits){
            set.add(s);
        }
        
        answer = new int[2];
        answer[0] = answer[1] = Integer.MAX_VALUE;
        
        dijkstra(gates, new boolean[n+1]);
        
        return answer;
    }
    
    static void dijkstra(int[] gates, boolean[] visited){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int g : gates){
            pq.add(new Node(g, 0));
        }
        
        Node current;
        while(!pq.isEmpty()){
            current = pq.poll();
            
            if(answer[1] < current.i) return;
            
            if(set.contains(current.n)){
                answer[0] = Math.min(answer[0], current.n);
                answer[1] = current.i;
                continue;
            }
            
            if(visited[current.n]) continue;
            visited[current.n] = true;
            
            for(Node next : adjList[current.n]){
                if(visited[next.n]) continue;
                pq.add(new Node(next.n, Math.max(current.i, next.i)));
            }
        }
    }
}

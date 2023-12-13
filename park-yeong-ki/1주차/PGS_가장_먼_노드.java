import java.util.*;

class PGS_가장_먼_노드 {
    static ArrayList<Integer>[] adjList;
    static class Node{
        int num, dist;

        Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }
    static int ans;

    public int solution(int n, int[][] edge) {
        adjList = new ArrayList[n+1]; //n개의 노드만큼 인접리스트 생성 -> 1번부터 n번까지
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<edge.length; i++){
            int to = edge[i][0];
            int from = edge[i][1];
            adjList[to].add(from); //무향그래프
            adjList[from].add(to);
        }

        bfs(new Node(1, 0));

        return ans;
    }

    static void bfs(Node start){
        Queue<Node> queue = new ArrayDeque();
        boolean[] visited = new boolean[adjList.length];

        queue.add(start);
        visited[start.num] = true;

        int max = Integer.MIN_VALUE;
        Node current;
        while(!queue.isEmpty()){
            current = queue.poll();

            if(current.dist > max){ //최대 거리를 갱신하는 경우
                max = current.dist;
                ans = 1; //멀리 떨어진 노드 수 초기화
            }else if(current.dist == max){ //최대 거리와 같은 경우
                ans++;
            }

            for(int next : adjList[current.num]){ //현재 점에서 갈 수 있는 곳 탐색
                if(visited[next]) continue; //이미 방문한 경우
                queue.add(new Node(next, current.dist + 1));
                visited[next] = true;
            }

        }
    }
}
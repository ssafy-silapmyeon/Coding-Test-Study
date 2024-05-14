import java.util.*;
class Solution {
    public class Node{
        int i,w;
        public Node(int i, int w){
            this.i = i;
            this.w = w;
        }
    }
    
    static ArrayList<Node>[] list;
    static int min = Integer.MAX_VALUE;
    static int result = 0;
    static HashSet<Integer> set = new HashSet<>();
    static HashSet<Integer> m = new HashSet<>();
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        //path 연결
        for(int i=0;i<paths.length;i++){
            int n1 = paths[i][0];
            int n2 = paths[i][1];
            list[n1].add(new Node(n2,paths[i][2]));
            list[n2].add(new Node(n1,paths[i][2]));
        }
        //출입문
        for(int i=0;i<gates.length;i++){
            set.add(gates[i]);
        }
        //산봉우리
        for(int i=0;i<summits.length;i++){
            m.add(summits[i]);
        }
        //산봉우리 기준
        Arrays.sort(summits);
        for(int i=0;i<summits.length;i++){
            int[] weight = new int[n+1];
            boolean[] visited = new boolean[n+1];
            for(int idx=1;idx<=n;idx++){
                weight[idx] = Integer.MAX_VALUE;
            }
            weight[summits[i]] =0;
            visited[summits[i]] = true;
            PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
            queue.offer(new Node(summits[i],0));
            
            while(!queue.isEmpty()){
                    Node cur = queue.poll();
                    if(set.contains(cur.i)){
                        break;
                    }
                    for(Node node: list[cur.i]){
                        if(m.contains(node.i)){
                            continue;
                        }
                        else{
                            int w = weight[cur.i] < node.w ? node.w : weight[cur.i];
                            if(weight[node.i] > w){
                                weight[node.i] = w;
                                queue.offer(new Node(node.i,weight[node.i]));
                            }
                        }
                        visited[node.i] = true;
                    }
            }
            
            for(int j=0;j<gates.length;j++){
                int idx = gates[j];
                if(weight[idx] < min){
                    min = weight[idx];
                    result = summits[i];
                }
            }
        }
        
        answer[0] = result;
        answer[1] = min;
        return answer;
    }
}
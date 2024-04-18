import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        LinkedList<Integer>[] list = new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new LinkedList<>();
        }
        for(int i=0;i<wires.length;i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        for(int i=0;i<wires.length;i++){
            int n1 = bfs(wires[i][0],wires[i][1],list);
            int n2 = bfs(wires[i][1],wires[i][0],list);
            if(Math.abs(n1-n2) < answer){
                answer = Math.abs(n1-n2);
            }
        }
        return answer;
    }
    
    public int bfs(int s, int e,LinkedList<Integer>[] list){
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        int result=1;
        
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i : list[n]){
                if(i == e || visited[i]){
                    continue;
                }
                queue.offer(i);
                visited[i] = true;
                result ++;
            }
        }
        return result;
    }
}
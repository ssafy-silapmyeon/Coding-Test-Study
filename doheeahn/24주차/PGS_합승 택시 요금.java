import java.util.*;

class Solution {
    static class Node{
        int n,f;
        Node(int n, int f){
            this.n = n;
            this.f =f;
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        LinkedList<Node>[] list = new LinkedList[n+1];
        int[][] arr = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            list[i] = new LinkedList<>();
        }
        for(int i=0;i<fares.length;i++){
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int fee = fares[i][2];
            list[n1].add(new Node(n2,fee));
            list[n2].add(new Node(n1,fee));
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=1;i<=n;i++){ //i에서 출발한다.
            boolean[] visited = new boolean[n+1];
            arr[i][i]=0;
            int cur = i;
            while(!visited[cur]){
                for(Node node :list[cur]){
                    if(arr[i][node.n] > arr[i][cur]+node.f){
                        arr[i][node.n] = arr[i][cur]+node.f;
                    }
                }
                visited[cur] = true;
                int min = Integer.MAX_VALUE;
                for(int j=1;j<=n;j++){
                    if(!visited[j]){
                        if(arr[i][j] < min){
                            min = arr[i][j];
                            cur = j;
                        }
                    }
                }
            }  
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(min > arr[s][i] + arr[i][a]+arr[i][b]){
                min = arr[s][i] + arr[i][a] +arr[i][b];
            }
        }
        answer = min;
        return answer;
    }
}
import java.util.*;

class PSG_순위 {
    static ArrayList<Integer>[] win;
    static ArrayList<Integer>[] lose;
    static int N;
    public int solution(int n, int[][] results) {
        N = n;
        win = new ArrayList[n+1]; //각 선수별 이긴 선수 저장
        lose = new ArrayList[n+1]; //각 선수별 진 선수 저장

        for(int i=1; i<=n; i++){
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }

        int w = 0;
        int l = 0;
        for(int i=0; i<results.length; i++){
            w = results[i][0];
            l = results[i][1];

            win[l].add(w);
            lose[w].add(l);
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(bfs(i)) ans++; //선수마다 탐색
        }

        return ans;
    }

    static boolean bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        queue.add(start);
        visited[start] = true;

        int current;
        int up = -1;
        while(!queue.isEmpty()){
            current = queue.poll();

            for(int num : win[current]){ //해당 선수를 이긴 선수들을 위로 올라가며 탐색
                if(visited[num]) continue;
                queue.add(num);
                visited[num] = true;
            }

            up++;
        }

        queue.clear();
        queue.add(start);
        int down = -1;
        while(!queue.isEmpty()){
            current = queue.poll();

            for(int num : lose[current]){ //해당 선수에게 패배했던 선수를 아래로 내려가며 탐색
                if(visited[num]) continue;
                queue.add(num);
                visited[num] = true;
            }

            down++;
        }

        return N == down+up+1; //탐색한 수가 총 선수의 수와 일치하는지 여부 반환
    }
}
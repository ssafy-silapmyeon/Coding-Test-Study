import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    static int[][] map;
    static int ans; // 모든 토마토가 익는데 걸린 시간
    static int M, N; // M:가로=j, N:세로=i

    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        Queue<Tomato> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }

        // 초기 토마토를 큐에 담았으니 BFS로 주변을 익히기 시작
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll(); // 익은 토마토가 나온다.

            ans = tomato.day; // 제일 마지막에 나온 토마토 day를 답으로 기록하기
            for(int d=0; d<4; d++) {
                int nexti = tomato.i + di[d];
                int nextj = tomato.j + dj[d];
                if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]==0) {
                    queue.add(new Tomato(nexti, nextj, tomato.day+1));
                    map[nexti][nextj] = 1;
                }
            }
        } // 큐가 빌때까지

        for(int i=0; i<N; i++) { // 안익은 토마토 체크
            for(int j=0; j<M; j++) {
                if(map[i][j]==0)
                    ans = -1;
            }
        }
        System.out.println(ans);
    }
    static class Tomato{
        int i, j, day;
        Tomato(int i, int j, int day){
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }
}

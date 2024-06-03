import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N*3][N];
        StringTokenizer st;
        for(int i=0; i<N*3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        backTracking(0, 0);

        System.out.println(ans);
    }

    static void backTracking(int cnt, int score){
        if(cnt == 3){
            ans = Math.max(ans, score);
            return;
        }

        boolean[][] visited = new boolean[N][N];
        int[][] oMap = new int[3*N][N];
        for(int i=0; i<3*N; i++){
            for(int j=0; j<N; j++){
                oMap[i][j] = map[i][j];
            }
        }
        
        for(int i=2*N; i<3*N; i++){
            for(int j=0; j<N; j++){
                if(visited[i - 2*N][j]) continue;
                int cs = bfs(new Point(i, j), visited);
                if(cnt < 2) fillMap();
                backTracking(cnt+1, score + cs);
                if(cnt < 2) restoreMap(oMap);
            }
        }
    }

    static void restoreMap(int[][] oMap){
        for(int i=0; i<3*N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = oMap[i][j];
            }
        }
    }

    static void fillMap(){
        for(int i=0; i<N; i++){
            int idx = -1;
            for(int j=3*N-1; j>=2*N; j--){
                if(map[j][i] == 0){
                    idx = j;
                    break;
                }
            }

            if(idx == -1) continue;
            for(int j=idx-1; j>=0; j--){
                if(map[j][i] != 0){
                    map[idx--][i] = map[j][i];
                    map[j][i] = 0;
                }
            }
        }
    }

    static int bfs(Point start, boolean[][] visited){
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.r - 2*N][start.c] = true;
        int car = map[start.r][start.c];
        map[start.r][start.c] = 0;

        Point cur;
        int rMin, rMax, cMin, cMax, cnt;
        cnt = 1;
        rMin = rMax = start.r;
        cMin = cMax = start.c;
        
        while(!queue.isEmpty()){
            cur = queue.poll();

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr < 2*N || nr >= 3*N || nc < 0 || nc >= N) continue;
                if(visited[nr - 2*N][nc]) continue;
                if(map[nr][nc] != car) continue;

                queue.add(new Point(nr,nc));
                visited[nr - 2*N][nc] = true;
                map[nr][nc] = 0;

                cnt++;
                rMin = Math.min(rMin, nr);
                rMax = Math.max(rMax, nr);
                cMin = Math.min(cMin, nc);
                cMax = Math.max(cMax, nc);
            }
        }

        return cnt + (rMax - rMin + 1) * (cMax - cMin + 1);
    }

    static class Point{
        int r, c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

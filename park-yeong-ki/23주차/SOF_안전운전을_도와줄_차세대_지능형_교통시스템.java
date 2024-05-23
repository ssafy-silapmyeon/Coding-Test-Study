import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0,-1,0,1};  //우상좌하
    static int[] dc = {1,0,-1,0};
    static int[][][] map;
    static boolean[][][] visited;
    static int N, T;
    static Set<Integer> set;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][N][4];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<4; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        visited = new boolean[N][N][4];
        set = new HashSet<>();        
        dfs(0,0,0,1);

        System.out.println(set.size());
    }

    static void dfs(int r, int c, int t, int d){
        if(t > T) return;
        if(r < 0 || r >= N || c < 0 || c >= N) return;
        if(visited[r][c][t%4]) return;
        set.add(r*N + c);
        
        int signal = map[r][c][t%4];
        int curD = signal % 4;
        if(curD != d) return;
        
        visited[r][c][t%4] = true;

        int nextD = signal / 4;
        int left = d+1 == 4 ? 0 : d+1;
        int right = d-1 == -1 ? 3 : d-1;
        
        switch(nextD){
            case 0:
                dfs(r+dr[left], c+dc[left], t+1, left);
                dfs(r+dr[d], c+dc[d], t+1, d);
                dfs(r+dr[right], c+dc[right], t+1, right);
                break;
            case 1:
                dfs(r+dr[left], c+dc[left], t+1, left);
                dfs(r+dr[d], c+dc[d], t+1, d);
                break;
            case 2:
                dfs(r+dr[d], c+dc[d], t+1, d);
                dfs(r+dr[right], c+dc[right], t+1, right);
                break;
        }
               
    }
}

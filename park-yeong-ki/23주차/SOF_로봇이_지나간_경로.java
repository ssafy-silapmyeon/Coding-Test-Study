import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int H, W;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static String str;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        int total = 0;
        String row;
        for(int i=0; i<H; i++){
            row = br.readLine();
            for(int j=0; j<W; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == '#'){
                    total++;
                }
            }
        }

        String[] ans = new String[4];
        String[] dir = {">", "v", "<", "^"};
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(map[i][j] == '#'){
                    for(int k=0; k<4; k++){
                        num = 0;
                        str = null;
                        move(i, j, k, 1, "");
                        if(num == total && (ans[3] == null || ans[3].length() > str.length())){
                            ans[0] = String.valueOf(i+1);
                            ans[1] = String.valueOf(j+1);
                            ans[2] = dir[k];
                            ans[3] = str;
                        }
                    }
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
        System.out.println(ans[2]);
        System.out.println(ans[3]);
    }

    static boolean isPossible(int r, int c, int d){
        for(int i=0; i<2; i++){
            r += dr[d];
            c += dc[d];
            if(r < 0 || r >= H || c < 0 || c >= W || map[r][c] != '#') return false;
        }

        return true;
    }

    static void move(int r, int c, int d, int cnt, String opr){
        int rd = d+1 == 4 ? 0 : d+1;
        int ld = d-1 == -1 ? 3 : d-1;
        
        if(isPossible(r,c,d)){
            move(r+2*dr[d], c+2*dc[d], d, cnt+2, opr + "A");
        }else if(isPossible(r,c,rd)){
            move(r+2*dr[rd], c+2*dc[rd], rd, cnt+2, opr + "RA");
        }else if(isPossible(r,c,ld)){
            move(r+2*dr[ld], c+2*dc[ld], ld, cnt+2, opr + "LA");
        }else{
            str = opr;
            num = cnt;
            return;
        }
    }
    
}

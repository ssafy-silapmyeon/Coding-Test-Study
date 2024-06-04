import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x, y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "x: " + x + " y: " + y;
        }
    }

    static ArrayList<Point>[] pList;
    static int K, ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pList = new ArrayList[K+1];
        for(int i=1; i<=K; i++){
            pList[i] = new ArrayList<>();
        }

        int x, y, k;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            pList[k].add(new Point(x,y));
        }

        ans = 4000001;
        comb(1, 1000, -1000, 1000, -1000);

        System.out.println(ans);
    }

    static void comb(int num, int minX, int maxX, int minY, int maxY){
        if(ans <= (maxX - minX) * (maxY - minY)) return;
        
        if(num == K+1){
            ans = (maxX - minX) * (maxY - minY);
            return;
        }

        for(Point p : pList[num]){
            comb(num+1, Math.min(p.x, minX), Math.max(p.x, maxX), Math.min(p.y, minY), Math.max(p.y, maxY));
        }
    }
}

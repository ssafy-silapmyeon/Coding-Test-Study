import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int ans=Integer.MAX_VALUE;
    static int k;
    static LinkedList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new LinkedList[k+1];
        for(int i=1;i<=k;i++){
            list[i] = new LinkedList<>();
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[c].add(new Node(x,y));
        }
        for(Node l : list[1]){
             comb(2,l.x,l.x,l.y,l.y);
        }
        System.out.println(ans);
    }

    static public void comb(int num, int maxX, int minX , int maxY, int minY){
        if(num > k){
            int result = (maxX-minX) * (maxY-minY);
            if(ans > result){
                ans = result;
            }
            return;
        }
        if(ans <= (maxX-minX) * (maxY-minY)){
            return;
        }


        for(Node l : list[num]){
            int x1 = maxX;
            int x2 = minX;
            int y1 = maxY;
            int y2 = minY;
            if(maxX < l.x){
                x1 = l.x;
            }
            if(minX > l.x){
                x2 = l.x;
            }
            if(maxY < l.y){
                y1 = l.y;
            }
            if(minY > l.y){
                y2 = l.y;
            }
            comb(num+1, x1, x2 , y1, y2);
        }
        
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        int[] computer = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            computer[i] = Integer.parseInt(st.nextToken());
        }

        long start = 1;
        long end = (long) 2e9+1;
        long mid;
        long cost;
        while(start < end){
            mid = (start + end) / 2;
            
            cost = 0;
            for(int c : computer){
                if(c < mid){
                    cost += Math.pow(mid-c, 2);
                }
            }

            if(cost <= B){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        System.out.println(end - 1);
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] bus = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            bus[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for(int i=0; i<N-2; i++){
            int cnt = 0;
            for(int j=N-1; j>i; j--){
                if(bus[i] > bus[j]){
                    cnt++;
                }else{
                    ans += cnt;
                }
            }
        }

        System.out.println(ans);
    }
}

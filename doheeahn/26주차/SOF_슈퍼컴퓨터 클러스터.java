import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long e = arr[0]+(long)Math.sqrt(b);
        long s = arr[0];
        long ans =0;

        
        while(s<=e){
            long mid = (s+e)/2;
            long result =0; //총 비용
            for(int i=0;i<n;i++){ 
                if(arr[i] <mid){
                    result += Math.pow((mid-arr[i]),2);
                }
            }

            if(result > b){
                e = mid-1;
            }
            else{
                s = mid+1;
                ans = mid;
            }
        }

        System.out.println(ans);


    }
}
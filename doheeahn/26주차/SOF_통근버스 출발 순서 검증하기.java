import java.io.*;
import java.util.*;

public class Main {

    static long ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] count = new long[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=i+1;j--){
                if(arr[j+1]!=0 && arr[i] > arr[j+1]){
                    count[i][j] = count[i][j+1]+1;
                }
                else{
                    count[i][j] = count[i][j+1];
                }   
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]< arr[j]){
                    ans += count[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}
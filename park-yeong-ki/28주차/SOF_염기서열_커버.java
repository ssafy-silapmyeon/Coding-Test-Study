import java.io.*;
import java.util.*;

public class Main {
    static char[][] DNA;
    static int[] count;
    static int N, M, min;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        DNA = new char[N][M];
        for(int i=0; i<N; i++){
            DNA[i] = br.readLine().toCharArray();
        }
        count = new int[1<<N];
        Arrays.fill(count, N+1);
        subset(0, 0);

        for(int i=1; i<(1<<N); i++){
            if(count[i] == 1) continue;
            count[i] = calculateCount(i);
        }

        System.out.println(count[(1<<N) - 1]);
    }

    static int calculateCount(int bit){
        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            if((bit & (1<<i)) != 0){
                list.add(i);
            }
        }
        
        min = N+1;
        subset2(0, 0, 0);

        return min;
    }

    static void subset2(int idx, int bit1, int bit2){
        if(idx == list.size()){
            min = Math.min(min, count[bit1] + count[bit2]);
            return;
        }

        subset2(idx+1, bit1 | 1<<list.get(idx), bit2);
        subset2(idx+1, bit1, bit2 | 1<<list.get(idx));
    }

    static boolean hasSuperDNA(int bit){
        char[] temp = new char[M];
        Arrays.fill(temp, '.');
        
        for(int i=0; i<N; i++){
            if((bit & (1<<i)) != 0){
                for(int j=0; j<M; j++){
                    if(temp[j] != '.' && DNA[i][j] != '.' && temp[j] != DNA[i][j]){
                        return false;
                    } else if(temp[j] == '.'){
                        temp[j] = DNA[i][j];
                    }
                }
            }
        }

        return true;
    }

    static void subset(int idx, int bit){
        if(idx == N){
            if(hasSuperDNA(bit)){
                count[bit] = 1;
            }
            return;
        }

        subset(idx+1, bit | 1<<idx);
        subset(idx+1, bit);
    }
}

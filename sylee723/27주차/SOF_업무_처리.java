import java.io.*;
import java.util.*;

public class Main {
    static int N, minLeaf, answer;
    static Queue<Integer>[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        N = (int)Math.pow(2, H + 1);        
        tree = new ArrayDeque[N][2];
        for (int i = 1; i < N; i++) {
            tree[i][0] = new ArrayDeque<>();
            tree[i][1] = new ArrayDeque<>();
        }

        minLeaf = (int)Math.pow(2, H);
        for (int i = minLeaf; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++) {
                tree[i][0].add(Integer.parseInt(st.nextToken()));
            }
        }

        int today = 1;
        answer = 0;
        while (today <= R) {
            for (int i = 1; i < N; i++) {
                work(i, today);
            }

            today++;
        }

        System.out.println(answer);
    }

    static void work(int num, int today) {
        int todo = 0;
        if (num < minLeaf) {
            todo = today % 2 == 1 ? 0 : 1; 
        }
       
        if (tree[num][todo].size() == 0) {
            return;
        }

        int done = tree[num][todo].poll();
        if (num == 1) {
            answer += done;
        } else {
            int pIdx = num / 2;
            int cIdx = num % 2;
            tree[pIdx][cIdx].add(done);            
        }        
    }
}

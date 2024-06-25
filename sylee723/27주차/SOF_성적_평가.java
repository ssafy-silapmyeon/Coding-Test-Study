import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] total = new int[N];
        StringTokenizer st;
        PriorityQueue<Member>[] pq = new PriorityQueue[4];
        for (int c = 0; c < 4; c++) {
            pq[c] = new PriorityQueue<>();
        }
        
        for (int c = 0; c < 3; c++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int score = Integer.parseInt(st.nextToken());
                pq[c].add(new Member(i, score));

                total[i] += score;
            }
        }

        for (int i = 0; i < N; i++) {
            pq[3].add(new Member(i, total[i]));
        }
        
        int[][] rank = new int[4][N];

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < 4; c++) {
            getRank(pq[c], rank[c]);
            for (int i = 0; i < N; i++) {
                sb.append(rank[c][i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void getRank(PriorityQueue<Member> pq, int[] rank) {
        int prevScore = 1001;
        int count = 0;
        int sameCnt = 1;
        while (!pq.isEmpty()) {
            Member now = pq.poll();
            if (prevScore != now.score) {
                count += sameCnt;
                rank[now.num] = count;
                sameCnt = 1;
            } else {
                rank[now.num] = count;
                sameCnt++;
            }

            prevScore = now.score;
        }
    }

    static class Member implements Comparable<Member> {
        int num, score;

        public Member(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Member o) {
            return -(this.score - o.score);
        }
    }
}

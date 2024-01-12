package footdev._5주차;

import java.util.*;
import java.io.*;

public class BOJ_아기_상어 {

    static final int[] dr = {0, 0, -1, 1};
    static final int[] dc = {-1, 1, 0, 0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static Shark shark;
    static PriorityQueue<Fish> pq = new PriorityQueue<>();

    public static void main(String[] args)throws IOException {
        //초기화
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                }
            }
        }

        //로직
        while (true) {
            searchByBfs();
            if (pq.isEmpty()) break;
            Fish fish = pq.poll();
            shark.eat(fish);
            pq.clear();
        }

        //출력
        System.out.println(shark.getSec());
    }

    static void searchByBfs() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][n];
        v[shark.getRow()][shark.getColumn()] = true;
        q.add(new Node(shark.getRow(), shark.getColumn(), 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                int state = map[nr][nc];
                if (v[nr][nc] || state == 9 || shark.getSize() < state) continue;
                if (state >= 1 && state <= 6 && shark.canEatFish(state)) {
                    pq.add(new Fish(state, cur.cnt + 1, nr, nc));
                }
                q.add(new Node(nr, nc, cur.cnt + 1));
                v[nr][nc] = true;
            }
        }
    }

    static class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static class Fish implements Comparable<Fish> {
        private int size;
        private int dist;
        private int r;
        private int c;

        public Fish(int size, int dist, int r, int c) {
            this.size = size;
            this.dist = dist;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            } else {
                if (this.r != o.r) {
                    return this.r - o.r;
                } else {
                    return this.c - o.c;
                }
            }
        }
    }

    static class Shark {
        private int r;
        private int c;
        private int size;
        private int eatCnt;
        private int sec;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = 2;
            this.eatCnt = 0;
            this.sec = 0;
        }

        public int getRow() {
            return this.r;
        }

        public int getColumn() {
            return this.c;
        }

        public int getSec() {
            return this.sec;
        }

        public int getSize() {
            return this.size;
        }
        private void moveTo(Fish fish) {
            map[this.r][this.c] = 0;
            this.r = fish.r;
            this.c = fish.c;
        }

        public void eat(Fish fish) {
            moveTo(fish);
            if (this.size == this.eatCnt + 1) {
                this.size++;
                this.eatCnt = 0;
            } else {
                this.eatCnt++;
            }
            this.sec += fish.dist;
            map[this.r][this.c] = 9;
        }

        public boolean canEatFish(int size) {
            return this.size > size;
        }
    }
}

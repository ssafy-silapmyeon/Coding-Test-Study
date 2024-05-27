import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[][][] rule;
    static int[] di = { 0, -1, 0, 1 };
    static int[] dj = { 1, 0, -1, 0 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        rule = new int[N][N][4];
        for (int k = 0; k < N * N; k++) {
            st = new StringTokenizer(br.readLine());
            int i = k / N;
            int j = k % N;
            
            for (int r = 0; r < 4; r++) {
                rule[i][j][r] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(drive());
    }

    static int drive() {
        boolean[][][][] visited = new boolean[N][N][4][4]; // i, j, carDir, ruleNum
        Queue<Car> queue = new ArrayDeque<>();

        visited[0][0][1][0] = true;
        queue.add(new Car(1, 0, 0, 0, 0));

        Set<Integer> cross = new HashSet<>();
        boolean[] availableDir;
        while (!queue.isEmpty()) {
            Car now = queue.poll();
            int crossNum = now.ei * N + now.ej;
            cross.add(crossNum);

            if (now.time == T) {
                continue;
            }

            int ruleNum = rule[now.ei][now.ej][now.time % 4];
            availableDir = findDirection(now, ruleNum);

            for (int d = 0; d < 4; d++) {
                if (!availableDir[d]) {
                    continue;
                }

                int nexti = now.ei + di[d];
                int nextj = now.ej + dj[d];
                int nextCarDir = getCarDir(now.ei, now.ej, nexti, nextj);
                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N
                   && !visited[nexti][nextj][nextCarDir][(now.time + 1) % 4]) {
                    visited[nexti][nextj][nextCarDir][(now.time + 1) % 4] = true;
                    queue.add(new Car(now.ei, now.ej, nexti, nextj, now.time + 1));
                }
            }
        }
        
        return cross.size();
    }

    static int getCarDir(int si, int sj, int ei, int ej) {
        int carDir = -1;
        if (si == ei) { // 좌우로 이동
            if (sj < ej) { // >
                carDir = 0;
            } else { // <
                carDir = 2;
            }
        } else { // 상하로 이동
            if (si > ei) { // ^
                carDir = 1;
            } else { // v
                carDir = 3;
            }
        }

        return carDir;
    }

    static boolean[] findDirection(Car car, int ruleNum) {
        int carDir = getCarDir(car.si, car.sj, car.ei, car.ej);
        
        boolean[] available = new boolean[4];
        if ((ruleNum - 1) % 4 != carDir) {
            return available;
        }

        if (ruleNum == 1) {
            available[0] = true;
            available[1] = true;
            available[3] = true;
        } else if (ruleNum == 2) {
            available[0] = true;
            available[1] = true;
            available[2] = true;
        } else if (ruleNum == 3) {
            available[1] = true;
            available[2] = true;
            available[3] = true;
        } else if (ruleNum == 4) {
            available[0] = true;
            available[2] = true;
            available[3] = true;
        } else if (ruleNum == 5 || ruleNum == 10) {
            available[0] = true;
            available[1] = true;
        } else if (ruleNum == 6 || ruleNum == 11) {
            available[1] = true;
            available[2] = true;
        } else if (ruleNum == 7 || ruleNum == 12) {
            available[2] = true;
            available[3] = true;
        } else if (ruleNum == 8 || ruleNum == 9) {
            available[0] = true;
            available[3] = true;
        } 
        
        return available;
    }

    static class Car {
        int si, sj, ei, ej, time;

        public Car(int si, int sj, int ei, int ej, int time) {
            this.si = si;
            this.sj = sj;
            this.ei = ei;
            this.ej = ej;
            this.time = time;
        }
    }
}

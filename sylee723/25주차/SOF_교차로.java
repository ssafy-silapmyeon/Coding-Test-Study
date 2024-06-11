import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Queue<Car>[] road;
    static int[] passTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        road = new ArrayDeque[4]; // 0: A, 1: B, 2: C, 3: D
        for (int r = 0; r < 4; r++) {
            road[r] = new ArrayDeque<>();
        }
        
        StringTokenizer st;
        int startTime = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int enterTime = Integer.parseInt(st.nextToken());
            int roadNum = st.nextToken().charAt(0) - 'A';

            road[roadNum].add(new Car(i, enterTime));

            if (i == 0) {
                startTime = enterTime;
            }
        }

        passTime = new int[N];
        Arrays.fill(passTime, -1);
        drive(startTime);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(passTime[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void drive(int startTime) {
        boolean[] passable = new boolean[4];
        int currentTime = startTime;
        while (true) {
            int passCnt = checkRight(currentTime, passable);
            if (passCnt == -1) {
                break;
            } else if (passCnt == 0) {
                int nextInTime = Integer.MAX_VALUE;
                for (int i = 0; i < 4; i++) {
                    if (road[i].isEmpty()) {
                        continue;
                    }
                    nextInTime = Math.min(nextInTime, road[i].peek().enterTime);
                }

                currentTime = nextInTime;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (passable[i]) {
                    Car car = road[i].poll();
                    passTime[car.num] = currentTime;
                }
            }
            currentTime++;
        }
    }

    static int checkRight(int time, boolean[] passable) {
        boolean[] ready = new boolean[4]; // 도로 위에 가야할 차가 있는지
        int readyCnt = 0;
        boolean isFinish = true;
        
        for (int i = 0; i < 4; i++) {
            if (road[i].isEmpty()) {
                continue;
            }

            isFinish = false;
            Car front = road[i].peek();
            if (front.enterTime <= time) {
                ready[i] = true;
                readyCnt++;
            }
        }

        if (readyCnt == 4 || isFinish) { // 교착 상태 or 모두 통과
            return -1;
        }

        int passCnt = 0;
        Arrays.fill(passable, false);
        for (int i = 0; i < 4; i++) {
            int rightIdx = (i == 0) ? 3 : i - 1;
            if (ready[i] && !ready[rightIdx]) {
                passCnt++;
                passable[i] = true;
            }
        }
        return passCnt;
    }

    static class Car {
        int num, enterTime;

        public Car(int num, int enterTime) {
            this.num = num;
            this.enterTime = enterTime;
        }
    }
}

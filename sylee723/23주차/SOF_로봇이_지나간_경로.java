import java.io.*;
import java.util.*;

public class Main {
    static char[] DIR = { '>', '<', 'v', '^'};
    static int[] di = { 0, 0, 1, -1 };
    static int[] dj = { 1, -1, 0, 0 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[][] map = new char[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            String line = br.readLine();
            for (int j = 1; j <= W; j++) {
                map[i][j] = line.charAt(j - 1);
            }
        }

        Point start = findStartPoint(map);
        String cmd = moveRobot(map, start);

        // 출력
        System.out.println(start.i + " " + start.j);
        System.out.println(DIR[start.dir]);
        System.out.println(cmd);
    }

    static Point findStartPoint(char[][] map) {
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (map[i][j] == '#') {
                    int count = 0;
                    int dir = -1;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];

                        if (map[ni][nj] == '#') {
                            count++;
                            dir = d;
                        }
                    }

                    if (count == 1) {
                        return new Point(i, j, dir);
                    }
                }
            }
        }

        return null;
    }

    static String moveRobot(char[][] map, Point start) {
        StringBuilder sb = new StringBuilder();
        Point now = new Point(start.i, start.j, start.dir);

        int nextDir;
        while (true) {
            nextDir = -1;
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if (map[nexti][nextj] == '#') {
                    nextDir = d;
                    break;
                }
            }
            
            if (nextDir == -1) { // 도착
                break;
            }

            if (now.dir != nextDir) { // 방향 회전
                sb.append(turn(now.dir, nextDir));
                now.dir = nextDir;
            }

            sb.append('A');
            for (int a = 0; a < 2; a++) {
                map[now.i][now.j] = '.';
                now.i += di[now.dir];
                now.j += dj[now.dir];
            }
        }

        return sb.toString();
    }

    static String turn(int nowD, int nextD) {
        switch (nowD) {
            case 0: // >
                if (nextD == 0) return "";
                else if (nextD == 1) return "RR";
                else if (nextD == 2) return "R";
                else if (nextD == 3) return "L";
                break;
            case 1: // <
                if (nextD == 0) return "RR";
                else if (nextD == 1) return "";
                else if (nextD == 2) return "L";
                else if (nextD == 3) return "R";
                break;
            case 2: // v
                if (nextD == 0) return "L";
                else if (nextD == 1) return "R";
                else if (nextD == 2) return "";
                else if (nextD == 3) return "RR";
                break;
            case 3: // ^
                if (nextD == 0) return "R";
                else if (nextD == 1) return "L";
                else if (nextD == 2) return "RR";
                else if (nextD == 3) return "";
                break;    
        }
        
        return "invalid direction";
    }

    static class Point {
        int i, j, dir;

        public Point(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }
}

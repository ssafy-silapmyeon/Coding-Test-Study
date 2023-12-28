import java.io.*;
import java.util.*;

public class BOJ_20055_컨베이어_벨트_위의_로봇 {
    static int n, k, left, right;
    static int[] belt;
    static boolean robot[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belt = new int[2 * n];
        robot = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++)
            belt[i] = Integer.parseInt(st.nextToken());
        left = 0;
        right = n;

        int count = 0;
        while (k > 0) {
            count++;
            moveBelt();
            moveRobot();
            newRobot();
        }

        System.out.println(count);
    }

    public static void moveBelt() {
        left--;
        right--;
        if (left == -1)
            left = 2 * n - 1;
        if (right == -1)
            right = 2 * n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (robot[i]) {
                robot[i] = false;
                if (i + 1 < n - 1)
                    robot[i + 1] = true;
            }
        }
    }

    public static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i]) {
                int next = left + i + 1;
                if (next >= 2 * n)
                    next -= 2 * n;
                if (!robot[i + 1] && belt[next] >= 1) {
                    robot[i] = false;
                    if (i + 1 < n - 1)
                        robot[i + 1] = true;
                    belt[next]--;
                    if (belt[next] == 0)
                        k--;
                }
            }
        }
    }

    public static void newRobot() {
        if (!robot[0] && belt[left] > 0) {
            robot[0] = true;
            belt[left]--;
            if (belt[left] == 0)
                k--;
        }
    }

}

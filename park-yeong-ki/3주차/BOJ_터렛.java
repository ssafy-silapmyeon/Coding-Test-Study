import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int x1, y1, r1, x2, y2, r2, dx, dy, cd, dr, rd;
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                sb.append(-1);
            } else {
                dx = x1 - x2;
                dy = y1 - y2;
                cd = dx * dx + dy * dy;

                dr = r1 + r2;
                rd = dr * dr;

                if (cd > rd) sb.append(0);
                else if (cd == rd) {
                    sb.append(1);
                } else {
                    dr = r1 - r2;
                    if (cd == dr * dr) sb.append(1);
                    else if (cd < dr * dr) sb.append(0);
                    else sb.append(2);
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}

package footdev._1주차;

import java.io.*;
import java.util.*;

public class BOJ_좌표_압축 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] points;
    static Set<Integer> s = new TreeSet<>();
    static Map<Integer, Integer> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        points = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
            s.add(points[i]);
        }

        //로직
        int idx = 0;
        for (Integer i : s) {
            m.put(i, idx++);
        }

        for (int i : points) {
            sb.append(m.get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }
}

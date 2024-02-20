package footdev._10주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_전깃줄 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[] dp;
    static Wire[] wires;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        wires = new Wire[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            wires[i] = new Wire(from, to);
        }

        //로직
        /*
        goal = 전깃줄이 서로 교차하지 않는 상태로 만들기 위해 제거해야 하는 전깃줄의 최소 개수 구하기

        그냥 최소 개수를 구하려면 교차여부를 판단해야 하기 때문에 구하기 번거롭다.
        전깃줄의 상한은 100개 이므로 모든 경우의 수를 탐색하게 되면 시간초과가 발생한다.

        전깃줄을 설치할 수 있는 최대 갯수를 구한 후에 전체 전깃줄 개수 - 설치 가능한 최대 개수를 해주면 제거해야 하는 최소 개수가 나온다.

        1. from 기준으로 정렬
        2. to 기준으로 LIS DP 구하기
        3. dp 값 중 max 구하기
        4. 전체 전깃줄 개수 - 구한 max값
        5. 출력
        */
        Arrays.sort(wires, new Comparator<Wire>() {
            @Override
            public int compare(Wire o1, Wire o2) {
                return o1.from - o2.from;
            }
        });

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (wires[j].to < wires[i].to) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int ans = n - Arrays.stream(dp).max().getAsInt();

        //출력
        System.out.println(ans);
    }
}

class Wire {
    int from;
    int to;

    public Wire(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

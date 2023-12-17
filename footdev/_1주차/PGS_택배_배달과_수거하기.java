package footdev._1주차;

public class PGS_택배_배달과_수거하기 {
    //현재 몇번 왔다갔다 거리며 배달/수거할 수 있는지에 대한 총량
    int d, p;
    long dist;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0 || pickups[i] > 0) {
                int cnt = 0;
                while (d < deliveries[i] || p < pickups[i]) {
                    d += cap;
                    p += cap;
                    cnt++;
                }
                d -= deliveries[i];
                p -= pickups[i];
                dist += (i + 1) * cnt * 2;
            }
        }

        return dist;
    }
}

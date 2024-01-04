package footdev._3주차;

import java.util.*;
import java.util.stream.Collectors;

public class PGS_두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        Queue<Integer> q1 = Arrays.stream(queue1)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        Queue<Integer> q2 = Arrays.stream(queue2)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        for (int i = 0; i <= 2 * n + 2; i++) {
            if (q1Sum == q2Sum) {
                return i;
            } else if (q1Sum > q2Sum) {
                Integer value = q1.remove();
                q1Sum -= value;

                q2.add(value);
                q2Sum += value;
            } else {
                Integer value = q2.remove();
                q2Sum -= value;

                q1.add(value);
                q1Sum += value;
            }
        }

        return -1;
    }
}
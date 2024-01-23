package footdev._6주차;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class PGS_N으로_표현 {
    /*

    1개로 표현할 수 있는 수 = 5
    2개로 표현할 수 있는 수 = 10, 0, 1, 25, 55
    3개로 표현할 수 있는 수 = 15, 5, 6, 31, 5, 5, 20, 50, 5, 125, 3, 5, 555
    .
    .
    .



    */

    public static void main(String[] args) {
        PGS_N으로_표현 obj = new PGS_N으로_표현();
        int res = obj.solution(5, 12);
        System.out.println(res);
    }

    public int solution(int N, int number) {
        List<Set<Integer>> sl = new ArrayList<Set<Integer>>(10);

        for (int i = 0; i < 10; i++) {
            sl.add(new TreeSet<>());
        }

        //1 ~ 8까지 표현할 수 있는 수 찾기
        sl.get(1).add(N);
        for (int i = 2; i <= 9; i++) {
            //N
            for (int j = 1; j <= i; j++) {
                Set<Integer> l = sl.get(j);
                Set<Integer> r = sl.get(i - j);

                for (int lNum : l) {
                    for (int rNum : r) {
                        sl.get(i).add(lNum + rNum);
                        sl.get(i).add(lNum - rNum);
                        sl.get(i).add(lNum * rNum);
                        if (lNum != 0 && rNum != 0) {
                            sl.get(i).add(lNum / rNum);
                        }
                    }
                }
            }
            sl.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> s : sl) {
            System.out.println("===================================");
            System.out.print("[");
            for (int i : s) {
                System.out.print(i + ", ");
            }
            System.out.println("]");
            System.out.println("====================================");
        }

        for (int i = 1; i < 10; i++) {
            if (sl.get(i).contains(number) && i < 9) {
                return i;
            }
        }

        return -1;
    }
}

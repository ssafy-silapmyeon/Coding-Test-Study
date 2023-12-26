package footdev._2주차;

import java.util.*;

class PGS_이모티콘_할인_행사 {

    static final int[] percents = {10, 20, 30, 40};

    int n, maxJoin, maxSum;
    int[] answer = {0, 0};

    public static void main(String[] args) {
        PGS_이모티콘_할인_행사 boj = new PGS_이모티콘_할인_행사();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] e = {1300, 1500, 1600, 4900};
        int[] ans = boj.solution(users, e);

        System.out.println("join = " + boj.maxJoin + " sum = " + boj.maxSum);
    }

    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        perm(0, 0, emoticons.length, new int[emoticons.length], users, emoticons);
        return new int[]{maxJoin, maxSum};
    }

    public void perm(int start, int depth, int r, int[] arr, int[][] users, int[] emoticons) {
        if (depth == r) {
            int sum = 0;
            int join = 0;
            int[] table = new int[n];
            //이코티콘 사기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < r; j++) {
                    if (arr[j] >= users[i][0]) {
                        int salePrice = emoticons[j] - (int)((double)emoticons[j] * ((double) arr[j] / 100));
                        sum += salePrice;
                        table[i] += salePrice;
                    }
                }
            }
            //가입자 선별하기 & 금액 차감
            for (int i = 0; i < n; i++) {
                if (table[i] >= users[i][1]) {
                    join++;
                    sum -= table[i];
                }
            }

            //최댓값 갱신
            if (join > maxJoin) {
                maxJoin = join;
                maxSum = sum;
            } else if (join == maxJoin) {
                maxSum = Math.max(maxSum, sum);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[depth] = percents[i];
            perm(i, depth + 1, r, arr, users, emoticons);
        }
    }

}


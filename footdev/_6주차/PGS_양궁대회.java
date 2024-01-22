package footdev._6주차;

import java.util.*;

class PGS_양궁대회 {

    TreeMap<Integer, List<int[]>> map = new TreeMap<>();

    public int[] solution(int n, int[] info) {

        //완탐
        search(n, 0, new int[11], info);

        //이기는 경우가 없으므로 -1 배열 리턴
        if (map.isEmpty()) {
            return new int[]{-1};
        }

        //점수차이가 가장 많이 나는 경우 가져오기
        Integer key = map.lastKey();
        List<int[]> maxScores = map.get(key);

        //그러한 경우가 여러 개 라면, 문제에 나온 조건대로 정렬
        if (maxScores.size() > 1) {
            maxScores.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    for (int i = 10; i >= 0; i--) {
                        if (a[i] != b[i]) {
                            return Integer.compare(b[i], a[i]);
                        }
                    }
                    return 0;
                }
            });
        }

        return maxScores.get(0);
    }

    public void search(int n, int depth, int[] score, final int[] info) {
        if (depth == 11 || n == 0) {
            int lionScore = 0, apeachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (score[i] == 0 && info[i] == 0) continue;
                if (score[i] > info[i]) {
                    lionScore += 10 - i;
                } else {
                    apeachScore += 10 - i;
                }
            }
            int gap = lionScore - apeachScore;
            if (gap > 0) {
                if (n > 0) {
                    score[10] += n;
                }
                if (!map.containsKey(gap)) {
                    map.put(gap, new ArrayList<>());
                }
                map.get(gap).add(score.clone());
                score[10] = 0;
            }
            return;
        }

        if (n > info[depth]) {
            score[depth] = info[depth] + 1;
            search(n - score[depth], depth + 1, score, info);
            score[depth] = 0;
        }
        search(n, depth + 1, score, info);
    }
}
package footdev._8주차;

import java.util.*;

public class PGS_메뉴_리뉴얼 {

    /*
    ans = 새로 추가될 코스요리 구성들
    chars = 손님들이 1번이라도 주문한 단일메뉴들
    orders = 각 손님마다 주문한 단일메뉴들
    candidates = course[n]의 갯수로 추가하게될 코스요리 후보군들
    */
    List<String> ans = new ArrayList<>();
    Character[] chars;
    HashSet<Character>[] orders;
    TreeMap<Integer, ArrayList<String>> candidates;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        this.orders = new HashSet[orders.length];

        for (int i = 0; i < this.orders.length; i++) {
            this.orders[i] = new HashSet<>();
        }

        Set<Character> s = new HashSet<>();

        //메뉴 구성에 쓸 단일메뉴 배열 가공
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                s.add(orders[i].charAt(j));
                this.orders[i].add(orders[i].charAt(j));
            }
        }

        chars = s.toArray(new Character[0]);
        Arrays.sort(chars);

        //조합 찾기
        for (int i = 0; i < course.length; i++) {
            //구성할 코스 요리의 모든 조합 중에서 후보군 찾기
            candidates = new TreeMap<>();
            comb(0, 0, course[i], new char[course[i]]);

            //후보군 중에서 실제 코스 요리 선정
            if (!candidates.isEmpty()) {
                Integer key = candidates.lastKey();
                String[] maxOrders = candidates.get(key).toArray(new String[0]);

                //정답 배열에 담기
                for (String order : maxOrders) {
                    ans.add(order);
                }
            }

        }

        return ans.stream()
                .sorted((a, b) -> {
                    int aSize = a.length();
                    int bSize = b.length();
                    for (int i = 0; i < Math.min(aSize, bSize); i++) {
                        char aChar = a.charAt(i);
                        char bChar = b.charAt(i);
                        if (aChar != bChar) {
                            return Integer.compare(aChar, bChar);
                        }
                    }

                    return Integer.compare(aSize, bSize);
                })
                .toArray(String[]::new);
    }

    public void comb(int depth, int idx, int r, char[] curr) {
        if (depth == r) {
            //해당 조합이 1 ~ N번까지 손님이 주문했는지 세기
            int cnt = 0;
            for (int i = 0; i < this.orders.length; i++) {
                boolean flag = true;
                for (int j = 0; j < curr.length; j++) {
                    if (!this.orders[i].contains(curr[j])) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                }
            }

            //cnt가 2 이상이면 후보군에 추가
            if (cnt >= 2) {
                if (!candidates.containsKey(cnt)) {
                    candidates.put(cnt, new ArrayList<>());
                }
                candidates.get(cnt).add(String.valueOf(curr));
            }

            return;
        }

        for (int i = idx; i < chars.length; i++) {
            curr[depth] = chars[i];
            comb(depth + 1, i + 1, r, curr);
        }
    }
}

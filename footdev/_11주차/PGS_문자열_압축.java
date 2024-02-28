package footdev._11주차;

import java.util.*;

class PGS_문자열_압축 {

    int min = Integer.MAX_VALUE;

    public int solution(String s) {

        //엣지 케이스 처리
        if (s.length() == 1) return 1;

        //로직
        int token = 1;
        int idx = 0;

        //자르는 단위가 길이의 반을 넘어서지 않아야함.
        while (token <= s.length() / 2) {
            idx = 0;
            Deque<String> q = new ArrayDeque<>();
            while (idx < s.length()) {
                if (idx + token > s.length()) {
                    q.add(s.substring(idx));
                    break;
                }
                String sub = s.substring(idx, idx + token);
                //큐가 비었으면 그냥 넣기
                if (q.isEmpty()) {
                    q.add(sub);
                }
                else {
                    //이전 토큰하고 같으면 뺀다음 카운트하기
                    if (q.peekLast().equals(sub)) {
                        //str은 이전 토큰
                        String str = q.pollLast();

                        //첫 연속적인 경우 처리
                        if (q.isEmpty() || !isNumberic(q.peekLast())) {
                            q.add("2");
                            q.add(str);
                        }
                        //2이상의 연속적인 경우 처리
                        else {
                            int cnt = Integer.parseInt(q.pollLast()) + 1;
                            q.add(String.valueOf(cnt));
                            q.add(str);
                        }
                    } else {
                        q.add(sub);
                    }
                }
                //idx를 토큰만큼 카운트
                idx += token;
            }

            StringBuilder sb = new StringBuilder();
            for (String str : q) {
                sb.append(str);
            }
            min = Math.min(min, sb.length());

            token++;
        }


        return min;
    }

    public boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}

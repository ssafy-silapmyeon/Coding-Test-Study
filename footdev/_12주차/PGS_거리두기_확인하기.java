package footdev._12주차;

import java.util.*;

class Solution {

    static List<Integer> ans = new ArrayList<>();

    public int[] solution(String[][] p) {

        /*
        맨해튼 거리 = (0, 0), (1, 1) (0 - 1) + (0 - 1) = 1 + 1 = 2

        1. 각 P의 좌표를 저장한다.
        2. 한개의 P당 자신을 제외한 모든 P에 대해서 맨해튼 거리를 구한다.
            2-1. 맨해튼 거리가 2 이하라면, 파티션이 조건에 부합하도록 설치되어 있는지 확인한다.
                2-1-1. 파티션이 조건에 맞게 설치되어 있다면 맞음.
                2-1-2. 조건에 맞게 설치되어 있지 않다면 지키고 있지 않은거임.
            2-2. 맨해튼 거리가 3 이상이면, 조건에 부합한다.
        3. 전부 유효하다면 1을 저장, 아니라면 0을 저장한다.
        4. 결과를 담은 배열을 return
        */

        //로직
        for (int i = 0; i < p.length; i++) {
            //문자열을 char형 2차원 배열로 변경
            char[][] m = new char[p[i].length][];
            for (int j = 0; j < p[i].length; j++) {
                m[j] = p[i][j].toCharArray();
            }

            //P의 좌표를 저장한다.
            List<Pos> ps = new ArrayList<>();
            for (int j = 0; j < m.length; j++) {
                for (int k = 0; k < m[j].length; k++) {
                    if (m[j][k] == 'P') ps.add(new Pos(j, k));
                }
            }

            //모든 P들 간의 맨해튼 거리를 구한다.
            boolean isValid = false;
            L:for (int j = 0; j < ps.size(); j++) {
                Pos curr = ps.get(j);
                for (int k = 0; k < ps.size(); k++) {
                    if (j == k) continue;
                    Pos other = ps.get(k);
                    int dist = Math.abs(curr.r - other.r) + Math.abs(curr.c - other.c);
                    //맨해튼 거리가 2이하 일 때
                    if (dist < 3) {
                        if (dist < 2) break L;
                        //파티션에 조건에 맞게 설정되어 있는지 확인
                        Pos[] pos = new Pos[2];
                        pos[0] = curr;
                        pos[1] = other;
                        Arrays.sort(pos);
                        //가로, 세로 일직선 상에 있을 때
                        if (pos[0].r == pos[1].r || pos[0].c == pos[1].c) {
                            //가로
                            if (pos[1].r == pos[0].r) {
                                if (m[pos[1].r][pos[1].c - 1] != 'X') break L;
                            }
                            //세로
                            else {
                                if (m[pos[1].r - 1][pos[1].c] != 'X') break L;
                            }
                        }
                        //대각선에 있을 때
                        else {
                            //좌상 대각선
                            if (pos[0].c < pos[1].c) {
                                if (m[pos[1].r][pos[1].c - 1] != 'X' || m[pos[1].r - 1][pos[1].c] != 'X') break L;
                            }
                            //우상 대각선
                            else {
                                if (m[pos[1].r - 1][pos[1].c] != 'X' || m[pos[1].r][pos[1].c + 1] != 'X') break L;
                            }
                        }
                    }
                }
                //마지막까지 다 돌았다는 건 특정 P의 자리에 대해서 모든 P의 자리가 유효하다는 이유이다.
                if (j == ps.size() - 1) isValid = true;
            }

            //P가 2미만일 때 엣지 케이스 처리
            if (ps.size() < 2) {
                ans.add(1);
            } else {
                ans.add(isValid ? 1 : 0);
            }
        }

        return ans.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}

class Pos implements Comparable<Pos> {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Pos o) {
        if (this.r != o.r) return this.r - o.r;
        return this.c - o.c;
    }
}
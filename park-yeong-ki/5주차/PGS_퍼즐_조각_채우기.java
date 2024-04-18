import java.util.*;

class PGS_퍼즐_조각_채우기 {
    static int row, col, ans;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Point{
        int r, c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static List<Point> temp;
    static boolean[] isCheckedB;
    static boolean[] isCheckedP;

    public int solution(int[][] game_board, int[][] table) {
        row = game_board.length;
        col = game_board[0].length;

        List<List<Point>> blank = new ArrayList<>();
        savePoint(game_board, blank, 1); //빈칸 탐색 -> 1이면 채워진칸 필터, 0이면 빈칸 필터
        ans = 0;
        isCheckedB = new boolean[blank.size()];
        for(int i=0; i<4; i++){
            List<List<Point>> puzzle = new ArrayList<>();
            savePoint(table, puzzle, 0);
            isCheckedP = new boolean[puzzle.size()];
            checkPoint(blank, puzzle, table);
            table = rotateMap(table);
        }

        return ans;
    }

    static void checkPoint(List<List<Point>> blank, List<List<Point>> puzzle, int[][] map){
        for(int i=0; i<blank.size(); i++){
            if(isCheckedB[i]) continue;

            outer:
            for(int j=0; j<puzzle.size(); j++){
                if(isCheckedP[j]) continue;
                List<Point> b = blank.get(i);
                List<Point> p = puzzle.get(j);
                if(b.size() != p.size()) continue;

                int r = b.get(0).r - p.get(0).r;
                int c = b.get(0).c - p.get(0).c;

                for(int k=0; k<b.size(); k++){
                    if(b.get(k).r != p.get(k).r + r ||
                            b.get(k).c != p.get(k).c + c) continue outer;
                }

                isCheckedB[i] = true;
                isCheckedP[j] = true;
                removePuzzle(puzzle.get(j), map);
                break;
            }


        }
    }

    static void removePuzzle(List<Point> list, int[][] map){
        for(Point p : list){
            map[p.r][p.c] = 0;
            ans++;
        }
    }

    static void printMap(int[][] map){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] rotateMap(int[][] map){
        int[][] copyMap = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                copyMap[j][row-1-i] = map[i][j];
            }
        }

        return copyMap;
    }

    static void printPoint(List<List<Point>> list){
        for(List<Point> l : list){
            System.out.println("빈공간");
            for(Point p : l){
                System.out.println(p.r + "/" + p.c);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void savePoint(int[][] map, List<List<Point>> list, int flag){
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(visited[i][j]) continue;
                if(map[i][j] == flag) continue;
                temp = new ArrayList<>();
                dfs(i, j, visited, map, flag);
                list.add(temp);
            }
        }
    }

    static void dfs(int r, int c, boolean[][] visited, int[][] map, int flag){
        visited[r][c] = true;
        temp.add(new Point(r, c));

        for(int i=0; i<4; i++){
            int tr = r + dr[i];
            int tc = c + dc[i];

            if(tr < 0 || tr >= row || tc < 0 || tc >= col) continue;
            if(visited[tr][tc]) continue;
            if(map[tr][tc] == flag) continue;

            dfs(tr, tc, visited , map, flag);
        }
    }
}
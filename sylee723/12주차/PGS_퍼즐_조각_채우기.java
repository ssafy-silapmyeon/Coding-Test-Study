import java.util.*;

class Solution {
    static List<List<Point>> puzzleList;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        pickUpPuzzles(table);
        int answer = putPuzzles(game_board);
        for (int d = 0; d < 3; d++) {
            game_board = turnBoard(game_board);
            answer += putPuzzles(game_board);
        }

        return answer;
    }
    
    static void pickUpPuzzles(int[][] table) {
        puzzleList = new ArrayList<>();
        
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1) {
                    List<Point> puzzle = bfs(i, j, table);
                    puzzleList.add(puzzle);
                }
            }
        }
        
        // System.out.println(puzzleList);
    }
    
    static List<Point> bfs(int si, int sj, int[][] table) {
        List<Point> puzzle = new ArrayList<>();
        Queue<Point> queue = new ArrayDeque<>();
        table[si][sj] = 0;
        queue.add(new Point(si, sj));
        
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            puzzle.add(new Point(now.i - si, now.j - sj));
            
            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];
                
                if (nexti < 0 || nexti >= table.length || nextj < 0 || nextj >= table.length) {
                    continue;
                }
                
                if (table[nexti][nextj] == 1) {
                    table[nexti][nextj] = 0;
                    queue.add(new Point(nexti, nextj));
                }
            }
        }
        
        return puzzle;
    }
    
    static class Point {
        int i, j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }
    
    static int[][] turnBoard(int[][] board) {
        // 시계방향 90도 회전
        int len = board.length;
        int[][] newBoard = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newBoard[j][len - i - 1] = board[i][j];
            }
        }
        
        return newBoard;
    }
    
    static int putPuzzles(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    for (List<Point> puzzle : puzzleList) {
                        if (isAvailable(puzzle, board, i, j)) {
                            count += puzzle.size();
                            // 퍼즐 채우기
                            for (Point p : puzzle) {
                                board[i + p.i][j + p.j] = 1;
                            }
                            
                            puzzleList.remove(puzzle);
                            break;
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    static boolean isAvailable(List<Point> puzzle, int[][] board, int si, int sj) {
        boolean[][] blankCheck = new boolean[board.length][board.length];
        
        for (Point p : puzzle) {
            int i = si + p.i;
            int j = sj + p.j;
            
            if (i < 0 || i >= board.length || j < 0 || j >= board.length || board[i][j] == 1) {
                return false;
            }
            
            blankCheck[i][j] = true;
        }
        
        for (Point p : puzzle) {
            int i = si + p.i;
            int j = sj + p.j;
            
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                
                if (ni < 0 || ni >= board.length || nj < 0 || nj >= board.length) {
                    continue;
                }
                
                if (board[ni][nj] == 0 && !blankCheck[ni][nj]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
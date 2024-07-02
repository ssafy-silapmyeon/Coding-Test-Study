import java.util.*;

class Solution {
    static boolean[][][] board;
    public int[][] solution(int n, int[][] build_frame) {
        board = new boolean[n + 1][n + 1][2];
        
        for (int k = 0; k < build_frame.length; k++) {
            int x = build_frame[k][0]; // 가로 좌표
            int y = build_frame[k][1]; // 세로 좌표 
            int a = build_frame[k][2]; // 0은 기둥, 1은 보
            int b = build_frame[k][3]; // 0은 삭제, 1은 설치
            
            if (isAvailable(x, y, a, b)) {
                if (b == 0) {
                    board[y][x][a] = false;
                } else {
                    board[y][x][a] = true;
                }
            }
        }
        
        ArrayList<int[]> answerList = new ArrayList<>();
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                for (int a = 0; a < 2; a++) {
                    if (board[i][j][a]) {
                        answerList.add(new int[] { j, i, a });
                    }
                }
            }
        }
        
        int[][] answer = new int [answerList.size()][];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static boolean isAvailable(int j, int i, int type, int install) {
        if (type == 0) { // 기둥
            if (install == 0) { // 삭제
                board[i][j][0] = false;
                
                for (int c = 0; c < board.length; c++) {
                    for (int r = 0; r < board.length; r++) {
                        for (int a = 0; a < 2; a++) {
                            if (board[r][c][a] && !isAvailable(c, r, a, 1)) {
                                board[i][j][0] = true;
                                return false;
                            }
                        }
                    }
                }
                
                board[i][j][0] = true;
                return true;
            } else { // 설치
                if (i == 0 
                    || (i > 0 && board[i - 1][j][0]) 
                    || board[i][j][1] || (j > 0 && board[i][j - 1][1])) {
                    return true;
                }
                
                return false;
            }
        } else { // 보
            if (install == 0) { // 삭제
                board[i][j][1] = false;
                
                for (int c = 0; c < board.length; c++) {
                    for (int r = 0; r < board.length; r++) {
                        for (int a = 0; a < 2; a++) {
                            if (board[r][c][a] && !isAvailable(c, r, a, 1)) {
                                board[i][j][1] = true;
                                return false;
                            }
                        }
                    }
                }
                
                board[i][j][1] = true;
                return true;
            } else { // 설치 
                if ((i > 0 && board[i - 1][j][0]) 
                    || (i > 0 && j + 1 < board.length && board[i - 1][j + 1][0]) 
                    || (j - 1 >= 0 && j + 1 < board.length && board[i][j - 1][1] && board[i][j + 1][1])) {
                    return true;
                }
                return false;
            }
        }
    }
}
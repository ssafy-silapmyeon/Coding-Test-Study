import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] d1, int[] d2) {
                if (d1[col - 1] == d2[col - 1]) {
                    return -(d1[0] - d2[0]);
                }
                return d1[col - 1] - d2[col - 1];
            }
        });
        
        int answer = 0;
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int S_i = 0;
            for (int j = 0; j < data[i].length; j++) {
                S_i += data[i][j] % (i + 1);
            }
            
            answer ^= S_i;
        }

        return answer;
    }
}
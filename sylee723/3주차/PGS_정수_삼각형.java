class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = -1;
                int right = -1;
                
                if (j - 1 >= 0) {
                    left = triangle[i - 1][j - 1];
                }
                if (j < triangle[i - 1].length) {
                    right = triangle[i - 1][j];
                }
                
                triangle[i][j] += Math.max(left, right);
            }
        }
        
        int h = triangle.length - 1;
        int answer = 0;
        for (int j = 0; j < triangle[h].length; j++) {
            answer = Math.max(answer, triangle[h][j]);
        }
        
        return answer;
    }
}
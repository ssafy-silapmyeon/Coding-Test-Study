class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int x = 3; ; x++) {
            if ((brown + yellow) % x == 0) {
                int y = (brown + yellow) / x;
                
                if (x + y == (brown / 2) + 2) {
                    answer[0] = Math.max(x, y);
                    answer[1] = Math.min(x, y);
                    break;
                }
            }
        }
        
        return answer;
    }
}
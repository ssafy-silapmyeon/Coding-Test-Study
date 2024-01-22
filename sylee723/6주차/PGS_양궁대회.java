class Solution {
    static int[] rScore;
    static int[] answer;
    static int maxDiff;
    public int[] solution(int n, int[] info) {
        maxDiff = 0;
        rScore = new int[11];
        answer = new int[11];
        comb(0, n, info);
        
        if (maxDiff == 0) {
            answer = new int[]{-1};
        }
        return answer;
    }
    
    static void comb(int count, int n, int[] info) {
        if (count == n) {
            int diff = 0;
            for (int i = 0; i <= 10; i++) {
                if (info[i] > rScore[i]) {
                    diff -= (10 - i);
                } else if (info[i] < rScore[i]) {
                    diff += (10 - i);
                } else if (info[i] != 0) {
                    diff -= (10 - i);
                }
            }
            
            if (diff > maxDiff) {
                maxDiff = diff;
                for (int i = 0; i <= 10; i++) {
                    answer[i] = rScore[i];
                }
            } else if (diff == maxDiff && diff > 0) {
                boolean update = false;
                for (int i = 10; i >= 0; i--) {
                    if (rScore[i] > answer[i]) {
                        update = true;
                        break;
                    } else if (rScore[i] < answer[i]) {
                        break;
                    }
                }
                
                if (update) {
                    for (int i = 0; i <= 10; i++) {
                        answer[i] = rScore[i];
                    }
                }
            }
            
            return;
        }
        
        for (int i = 0; i < 10; i++) {
            if (rScore[i] <= info[i] && count + info[i] + 1 <= n) {
                rScore[i] = info[i] + 1;
                comb(count + info[i] + 1, n, info);
                rScore[i] = 0;
            }
        }
        
        if (n - count > 0) {
            rScore[10] = n - count;
            comb(n, n, info);
            rScore[10] = 0;
        }
    }
}
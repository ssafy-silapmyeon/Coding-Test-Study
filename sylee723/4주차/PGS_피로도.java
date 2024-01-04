class Solution {
    static int answer;
    static boolean[] selected;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        selected = new boolean[dungeons.length];
        perm(k, dungeons, 0, 0);
        return answer;
    }
    
    static public void perm(int k, int[][] dungeons, int idx, int count) {
        if (k == 0 || idx == dungeons.length) {
            answer = Math.max(answer, count);
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!selected[i]) {
                if (k >= dungeons[i][0]) {
                    selected[i] = true;
                    perm(k - dungeons[i][1], dungeons, idx + 1, count + 1);
                    selected[i] = false;
                } else {
                    selected[i] = true;
                    perm(k, dungeons, idx + 1, count);
                    selected[i] = false;  
                }
            }
        }
    }
}
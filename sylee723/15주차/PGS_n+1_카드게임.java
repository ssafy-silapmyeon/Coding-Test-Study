class Solution {
    static int N, leftCoin;
    static boolean[] mine, selected;
    
    public int solution(int coin, int[] cards) {
        N = cards.length;
        leftCoin = coin;
        mine = new boolean[N + 1];
        selected = new boolean[N + 1];
        
        for (int i = 0; i < N / 3; i++) {
            mine[cards[i]] = true;
        }
        
        int idx = N / 3;
        int round = 1;
        
        while (idx < N) {
            int c1 = cards[idx++];
            int c2 = cards[idx++];
            
            selected[c1] = true;
            selected[c2] = true;
            
            if (!putDown() && !pickCard()) {
                break;
            }
            
            round++;
        }
            
        return round;
    }
    
    static boolean putDown() {
        for (int i = 1; i <= N/2; i++) {
            if (mine[i] && mine[N + 1 - i]) {
                mine[i] = false;
                mine[N + 1 - i] = false;
                
                return true;
            }
        }
        
        return false;
    }
    
    static boolean pickCard() {
        if (leftCoin == 0) {
            return false;
        }
        
        if (leftCoin >= 1) {
            for (int i = 1; i <= N; i++) {
                if (mine[i] && selected[N + 1 - i]) {
                    leftCoin--;
                    selected[N + 1 - i] = false;
                    mine[i] = false;
                    
                    return true;
                }
            }
        }
        
        if (leftCoin >= 2) {
            for (int i = 1; i <= N / 2; i++) {
                if (selected[i] && selected[N + 1 - i]) {
                    leftCoin -= 2;
                    selected[i] = false;
                    selected[N + 1 - i] = false;
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}
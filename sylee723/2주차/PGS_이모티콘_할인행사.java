class Solution {
    static int maxCnt, maxAmt;
    static int[] EMOTICONS;
    static int[][] sales, USERS;
    public int[] solution(int[][] users, int[] emoticons) {
        sales = new int[emoticons.length][2];
        USERS = new int[users.length][2];
        EMOTICONS = new int[emoticons.length];
        
        for (int i = 0; i < users.length; i++) {
            USERS[i][0] = users[i][0];
            USERS[i][1] = users[i][1];
        }
        for (int i = 0; i < emoticons.length; i++) {
            EMOTICONS[i] = emoticons[i];
        }
        
        maxCnt = 0;
        maxAmt = 0;
        
        setSales(0);
        
        int[] answer = { maxCnt, maxAmt };
        return answer;
    }
    
    static void setSales(int idx) {
        if (idx == sales.length) {
            checkUser();
            return;
        }
        
        for (int s = 10; s <= 40; s += 10) {
            sales[idx][0] = s;
            sales[idx][1] = EMOTICONS[idx] * (100 - s) / 100;
            setSales(idx + 1);
        }
    }
    
    static void checkUser() {
        int count = 0;
        int totalAmt = 0;
        int amount;
        for (int u = 0; u < USERS.length; u++) {
            amount = 0;
            for (int s = 0; s < sales.length; s++) {
                if (USERS[u][0] <= sales[s][0]) {
                    amount += sales[s][1];
                }
            }
            
            if (amount >= USERS[u][1]) {
                count++;
            } else {
                totalAmt += amount;
            }
        }
        
        if (maxCnt < count) {
            maxCnt = count;
            maxAmt = totalAmt;
        } else if (maxCnt == count) {
            maxAmt = Math.max(maxAmt, totalAmt);
        }
    }
}
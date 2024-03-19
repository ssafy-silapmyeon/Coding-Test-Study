import java.util.*;

class Solution {
    static int[] result;
    static Map<Integer, int[]> sumCntArr;
    static int[][] DICE;
    static int MAX;
    public int[] solution(int[][] dice) {
        DICE = new int[dice.length][6];
        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < 6; j++) {
                DICE[i][j] = dice[i][j];
            }
        }
        result = new int[dice.length / 2];
        sumCntArr = new HashMap<>();
        MAX = dice.length / 2 * 100;
        comb(0, 0, dice.length);
        
        return gameCount();
    }
    
    static void comb(int idx, int start, int n) {
        if (idx == result.length) {
            ArrayList<Integer> sumList = getSumList(new ArrayList<>(), 0);
            int key = 0;
            for (int i = 0; i < result.length; i++) {
                key |= (1 << result[i]);
            }
            
            getSumCount(key, sumList);
            return;
        }
        
        for (int i = start; i < n; i++) {
            result[idx] = i;
            comb(idx + 1, i + 1, n);
        }
    }
    
    static ArrayList<Integer> getSumList(ArrayList<Integer> sumList, int diceIdx) {
        if (diceIdx == result.length) {
            return sumList;
        }
        
        if (sumList.size() == 0) {
            sumList.add(0);
        }
        
        ArrayList<Integer> addList = new ArrayList<>();
        for (int sum : sumList) {
            for (int i = 0; i < 6; i++) {
                addList.add(sum + DICE[result[diceIdx]][i]);
            }
        }

        return getSumList(addList, diceIdx + 1);
    }
    
    static void getSumCount(int key, ArrayList<Integer> sumList) {
        int[] sumCnt = new int[MAX + 1];
        for (int sum : sumList) {
            sumCnt[sum]++;
        }
        
        sumCntArr.put(key, sumCnt);
    }
    
    static int[] gameCount() {
        int win = 0;
        int winKey = 0;
        for (int k1 : sumCntArr.keySet()) {
            for (int k2 : sumCntArr.keySet()) {
                if ((k1 & k2) == 0) {
                    int count = 0;
                    int[] s1 = sumCntArr.get(k1);
                    int[] s2 = sumCntArr.get(k2);
                    for (int i = 1; i <= MAX; i++) {
                        for (int j = 1; j < i; j++) {
                            count += s1[i] * s2[j];
                        }
                    }
                    
                    if (count > win) {
                        winKey = k1;
                        win = count;
                    }
                }
            }
        }
        
        int[] answer = new int[DICE.length / 2];
        int idx = 0;
        for (int i = 0; i < DICE.length; i++) {
            if ((winKey & (1 << i)) > 0) {
                answer[idx] = i + 1;
                idx++;
            }
        }
        
        return answer;
    }
}
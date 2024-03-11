import java.util.*;

class Solution {
    static char[] opType = {'+', '-', '*'};
    static int[] order = new int[3];
    static boolean[] selected = new boolean[3];
    static long answer;
    static ArrayList<Long> numList;
    static ArrayList<Character> opList;
    
    public long solution(String expression) {
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        int start = 0; 
        int end = 0;
        while (true) {
            while (end < expression.length() 
                   && expression.charAt(end) >= '0' && expression.charAt(end) <= '9') {
                end++;
            }
            
            Long num = Long.parseLong(expression.substring(start, end));
            numList.add(num);

            if (end == expression.length()) {
                break;
            }
            opList.add(expression.charAt(end));
            start = end + 1;
            end++;
        }
        
        answer = 0;
        perm(0);
        
        return answer;
    }
    
    static void perm(int idx) {
        if (idx == 3) {
            answer = Math.max(answer, calculate());
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!selected[i]) {
                order[idx] = i;
                selected[i] = true;
                perm(idx + 1);
                selected[i] = false;
            }
        }
    }
    
    static Long calculate() {
        ArrayList<Long> numCopy = new ArrayList<>();
        ArrayList<Character> opCopy = new ArrayList<>();
        for (Long num : numList) {
            numCopy.add(num);
        }
        for (Character op : opList) {
            opCopy.add(op);
        }
        
        for (int i = 0; i < 3; i++) {
            // opType[order[i]] 연산부터 수행
            ArrayList<Integer> removeList = new ArrayList<>();
            for (int o = 0; o < opCopy.size(); o++) {
                if (opCopy.get(o) == opType[order[i]]) {
                    Long result = 0l;
                    switch (opCopy.get(o)) {
                        case '+':
                            result = numCopy.get(o) + numCopy.get(o + 1);
                            break;
                        case '-':
                            result = numCopy.get(o) - numCopy.get(o + 1);
                            break;
                        case '*':
                            result = numCopy.get(o) * numCopy.get(o + 1);
                            break;
                    }
                    numCopy.set(o + 1, result);
                    removeList.add(o);
                }
            }
            
            // 사용한 연산자 제거
            for (int r = removeList.size() - 1; r >= 0; r--) {
                int idx = removeList.get(r);
                numCopy.remove(idx);
                opCopy.remove(idx);
            }
        }
        
        // 계산 결과의 절댓값 리턴 
        if (numCopy.get(0) > 0)
            return numCopy.get(0);
        else 
            return (-1) * numCopy.get(0);
    }
}
import java.util.*;

class Solution {
    static char[] member = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
    static int M = member.length;
    static Map<Character, Integer> memNum;
    static Map<Integer, int[]> memDistance;
    static int[] result;
    static boolean[] selected;
    static int answer;
    
    public int solution(int n, String[] data) {
        memNum = new HashMap<>();
        memDistance = new HashMap<>();
        
        for (int i = 0; i < M; i++) {
            memNum.put(member[i], i);
        }
        
        if (!isValid(data)) {
            return 0;
        }
        
        result = new int[M];
        selected = new boolean[M];
        answer = 0;
        perm(0);
        
        return answer;
    }
    
    static boolean isValid(String[] data) {
        boolean valid = true;
        for (String str : data) {
            int m1 = memNum.get(str.charAt(0));
            int m2 = memNum.get(str.charAt(2));
           
            int partner = (1 << m1) | (1 << m2);
            int[] distMinMax = memDistance.getOrDefault(partner, new int[] {0, 6});
            
            int dist = str.charAt(4) - '0';
            switch (str.charAt(3)) {
                case '=':
                    if (distMinMax[0] <= dist && dist <= distMinMax[1]) {
                        distMinMax[0] = dist;
                        distMinMax[1] = dist;
                    } else {
                        valid = false;
                    }
                    break;
                case '<':
                    if (distMinMax[0] <= dist - 1) {
                        distMinMax[1] = Math.min(distMinMax[1], dist - 1);
                    } else {
                        valid = false;
                    }
                    break;
                case '>':
                    if (dist + 1 <= distMinMax[1]) {
                        distMinMax[0] = Math.max(distMinMax[0], dist + 1);
                    } else {
                        valid = false;
                    }
                    break;    
            }
            
            if (!valid) {
                return valid;
            }
            
            memDistance.put(partner, distMinMax);
        }
        
        return valid;
    }
    
    static void perm(int idx) {
        if (idx == M) {
            boolean available = true;
            for (int partner : memDistance.keySet()) {
                int m1 = -1;
                int m2 = -1;
                for (int i = 0; i < M; i++) {
                    if ((partner & (1 << i)) > 0) {
                        if (m1 == -1) {
                            m1 = i;
                        } else {
                            m2 = i;
                        }
                    }
                }
                
                int m1Idx = -1;
                int m2Idx = -1;
                
                for (int i = 0; i < M; i++) {
                    if (result[i] == m1) {
                        m1Idx = i;
                    } else if (result[i] == m2) {
                        m2Idx = i;
                    }
                }
                
                int min = memDistance.get(partner)[0];
                int max = memDistance.get(partner)[1];
                
                int distance = Math.abs(m1Idx - m2Idx) - 1;
                if (distance < min || distance > max) {
                    available = false;
                    break;
                }
            }
            
            if (available) {
                answer++;
            }
            
            return;
        }
        
        for (int i = 0; i < M; i++) {
            if (!selected[i]) {
                selected[i] = true;
                result[idx] = i;
                perm(idx + 1);
                selected[i] = false;
            }
        }
    }
}
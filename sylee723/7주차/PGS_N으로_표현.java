import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] numSet = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            numSet[i] = new HashSet<>();
        }
        
        numSet[1].add(N);
        for (int i = 2; i <= 8; i++) {
            int left = 1;
            int right = i - left;
            
            while (left <= right) {
                for (int lNum : numSet[left]) {
                    for (int rNum : numSet[right]) {
                        numSet[i].add(lNum + rNum);
                        numSet[i].add(lNum * rNum);
                        numSet[i].add(lNum - rNum);
                        numSet[i].add(rNum - lNum);
                        
                        if (lNum != 0) {
                            numSet[i].add(rNum / lNum);
                        }
                        if (rNum != 0) {
                            numSet[i].add(lNum / rNum);
                        }
                    }
                }
                
                left++;
                right--;
            }
            
            // N으로 이루어진 i 자리수
            int num = N;
            for (int d = 1; d < i; d++) {
                num = num * 10 + N;
            }
            numSet[i].add(num);
        }
        
        int answer = -1;
        for (int i = 1; i <= 8; i++) {
            if (numSet[i].contains(number)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
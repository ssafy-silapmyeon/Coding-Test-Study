import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] mul = new int[arr.length];
        Arrays.fill(mul, 1);
        
        while (true) {
            int max = -1;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] * mul[i] > max) {
                    max = arr[i] * mul[i];
                }
            }

            boolean finish = true;
            for (int i = 0; i < arr.length; i++) {
                if (max > arr[i] * mul[i]) {
                    mul[i] = max / arr[i];
                    if (max % arr[i] != 0) {
                        mul[i]++;
                    }
                    finish = false;
                }
            }
            
            if (finish) {
                break;
            }
        }
        
        int answer = arr[0] * mul[0];
        return answer;
    }
}
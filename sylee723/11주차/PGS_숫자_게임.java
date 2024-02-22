import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int idxA = 0;
        int idxB = 0;
        
        while (idxA < A.length && idxB < B.length) {
            while (idxB < B.length && A[idxA] >= B[idxB]) {
                idxB++;
            }
            
            if (idxB < B.length) {
                answer++;
            }
            idxA++;
            idxB++;
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int resultA = 0;
        for (int i = 0; i < arrayA.length; i++) {
            resultA = gcd(resultA, arrayA[i]);
        }
        
        int resultB = 0;
        for (int i = 0; i < arrayB.length; i++) {
            resultB = gcd(resultB, arrayB[i]);
        }
        
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % resultA == 0) {
                resultA = 0;
                break;
            }
        }
        
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % resultB == 0) {
                resultB = 0;
                break;
            }
        }

        int answer = Math.max(resultA, resultB);
        return answer;
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}
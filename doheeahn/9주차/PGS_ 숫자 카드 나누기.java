class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int maxA = arrayA[0];
        int maxB = arrayB[0];
        
        for(int i=1;i<arrayA.length;i++){
            maxA = gcd(maxA,arrayA[i]);
            maxB = gcd(maxB,arrayB[i]);
        }
        if(check(arrayA,maxB)){
            answer = maxB;
        }
        if(check(arrayB,maxA)){
            answer = maxA>answer ? maxA:answer;
        }
        return answer;
    }
    public int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
    public boolean check(int[] arr, int max){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%max ==0){
                return false;
            }
        }
        return true;
    }
}
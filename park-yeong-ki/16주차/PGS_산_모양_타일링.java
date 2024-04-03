class Solution {
    public int solution(int n, int[] tops) {
        int[] a = new int[n];
        int[] b = new int[n];
        
        a[0] = 1; //역삼각형을 오른쪽 정삼각형과 함께 덮는 방법
        b[0] = tops[0] == 1 ? 3 : 2; //역삼각형을 덮는 그외 방법
        int mod = 10007;
        for(int i=1; i<tops.length; i++){
            if(tops[i] == 1){
                a[i] = (a[i-1] + b[i-1]) % mod;
                b[i] = (a[i-1] * 2 + b[i-1] * 3) % mod;
            }else{
                a[i] = (a[i-1] + b[i-1]) % mod;
                b[i] = (a[i-1] + b[i-1] * 2) % mod;
            }
        }
        
        return (a[n-1] + b[n-1]) % mod;
    }
}

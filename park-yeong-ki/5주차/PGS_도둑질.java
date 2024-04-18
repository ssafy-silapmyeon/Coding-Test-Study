class PGS_도둑질 {
    public int solution(int[] money) {
        int len = money.length;
        int[] arr1 = new int[len-1];
        int[] arr2 = new int[len-1];
        for(int i=0; i<len; i++){
            if(i<len-1) arr1[i] = money[i];
            if(i>=1) arr2[i-1] = money[i];
        }

        int[] dp1 = new int[len-1];
        dp1[0] = arr1[0];
        dp1[1] = Math.max(arr1[1], dp1[0]);

        int[] dp2 = new int[len-1];
        dp2[0] = arr2[0];
        dp2[1] = Math.max(arr2[1], dp2[0]);

        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(dp1[i-2] + arr1[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + arr2[i], dp2[i-1]);
        }

        return Math.max(dp1[len-2], dp2[len-2]);
    }
}
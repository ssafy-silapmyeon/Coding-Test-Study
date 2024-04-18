class PGS_스티커_모으기_2 {
    public int solution(int sticker[]) {
        int N = sticker.length;

        if(N == 1) return sticker[0];

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        for(int i=0; i<N; i++){
            if(i < N-1) arr1[i] = sticker[i];
            if(i >= 1) arr2[i-1] = sticker[i];
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        dp1[0] = arr1[0];
        dp1[1] = Math.max(arr1[1], dp1[0]);
        dp2[0] = arr2[0];
        dp2[1] = Math.max(arr2[1], dp2[0]);

        for(int i=2; i<N-1; i++){
            dp1[i] = Math.max(dp1[i-2] + arr1[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + arr2[i], dp2[i-1]);
        }

        return Math.max(dp1[N-2], dp2[N-2]);
    }
}
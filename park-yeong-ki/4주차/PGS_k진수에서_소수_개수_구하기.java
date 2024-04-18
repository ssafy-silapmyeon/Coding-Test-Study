class PGS_k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();

        String[] nums = sb.toString().split("0");

        long num;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i].equals("")) continue;
            num = Long.parseLong(nums[i]);
            if(isPrime(num)) ans++;
        }

        return ans;
    }

    static boolean isPrime(long num){
        if(num == 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
}
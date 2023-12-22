class PSG_이모티콘_할인행사 {
    static int[] sale = {10, 20, 30, 40};
    static int[] arr;
    static int[] ans;

    public int[] solution(int[][] users, int[] emoticons) {
        ans = new int[2];
        arr = new int[emoticons.length];
        comb(0, users, emoticons);

        return ans;
    }

    static void calculate(int[][] users, int[] emoticons){
        int sCnt = 0;
        int tPrice = 0;
        for(int i=0; i<users.length; i++){
            int rate = users[i][0];
            int limit = users[i][1];
            int sum = 0;

            for(int j=0; j<emoticons.length; j++){
                if(arr[j] >= rate){ //이모티콘 구매
                    sum += emoticons[j] * ((100 - arr[j]) / (double)100);
                }
            }

            if(sum >= limit){ //구매 비용을 넘어서는 경우
                sCnt++;
            }else{
                tPrice += sum;
            }
        }

        updateAns(sCnt, tPrice);
    }

    static void updateAns(int sCnt, int tPrice){
        if(ans[0] < sCnt){ //서비스 가입자 갱신
            ans[0] = sCnt;
            ans[1] = tPrice;
        }else if(ans[0] == sCnt){ //서비스 가입자가 같으면 판매액 갱신
            if(ans[1] < tPrice){
                ans[1] = tPrice;
            }
        }
    }

    static void comb(int cnt, int[][] users, int[] emoticons){
        if(cnt == emoticons.length){ //이모티콘별 할인율 조합 완성
            calculate(users, emoticons);
            return;
        }

        for(int i=0; i<sale.length; i++){
            arr[cnt] = sale[i];
            comb(cnt+1, users, emoticons);
        }
    }
}
class PSG_택배_배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int dIdx = n-1;
        int pIdx = n-1;

        long ans = 0;
        while(true){
            while(dIdx >= 0 && deliveries[dIdx] == 0){ //0이면 앞으로 땡김
                dIdx--;
            }

            while(pIdx >= 0 && pickups[pIdx] == 0){ //0이면 앞으로 땡김
                pIdx--;
            }

            if(dIdx == -1 && pIdx == -1) break;

            ans += (Math.max(dIdx, pIdx) + 1) * 2;
            int dBox = cap;
            for(int i=dIdx; i>=0; i--){ //배달 탐색
                if(deliveries[i] > dBox){
                    deliveries[i] -= dBox;
                    dBox = 0;
                }else if(deliveries[i] == dBox){
                    deliveries[i] = 0;
                    dBox = 0;
                }else{
                    dBox -= deliveries[i];
                    deliveries[i] = 0;
                }

                if(dBox == 0){ //가지고 간 배달박스를 모두 소거
                    dIdx = i;
                    break;
                }
            }

            if(dBox != 0){ //더이상 배달할 집이 없는 경우
                dIdx = 0;
            }

            int pBox = cap;
            for(int i=pIdx; i>=0; i--){ //수거 탐색
                if(pickups[i] > pBox){
                    pickups[i] -= pBox;
                    pBox = 0;
                }else if(pickups[i] == pBox){
                    pickups[i] = 0;
                    pBox = 0;
                }else{
                    pBox -= pickups[i];
                    pickups[i] = 0;
                }

                if(pBox == 0){ //가지고 올 수 있는 수거박스를 모두 소거
                    pIdx = i;
                    break;
                }
            }

            if(pBox != 0){ //더이상 수거할 집이 없는 경우
                pIdx = 0;
            }

        }

        return ans;
    }
}
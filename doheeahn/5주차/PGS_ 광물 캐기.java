class Solution {
    static int[][] map = {{1,1,1},{5,1,1},{25,5,1}};
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        perm(picks,minerals,0,0);
        answer = min;
        return answer;
    }
    
    public void perm(int[] pick ,String[] minerals, int idx,int result){
        if(idx == minerals.length || pick[0]+pick[1]+pick[2]==0){
            min = min > result ? result : min;
            return;
        }
        
        
        for(int i=0;i<3;i++){
            int[] arr = new int[3];
            for(int j=0;j<3;j++){
                arr[j] = pick[j];
            }
            int cnt =0; //곡괭이가 몇개의 광물을 캤는지 최대 5개
            int sum =0;//해당 곡괭이로 얻은 피로도
            
            
            if(pick[i]==0){//곡괭이 없음
                continue;
            }
            
            arr[i]-=1;//i 곡괭이 선택
            while(cnt <5 && idx+cnt < minerals.length){
                if(minerals[idx+cnt].equals("diamond")){
                    sum +=map[i][0];
                }
                else if(minerals[idx+cnt].equals("iron")){
                    sum += map[i][1];
                }
                else{
                    sum += map[i][2];
                }
                cnt++;
            }
            
            if(sum +result >= min){
                continue;
            }
            perm(arr,minerals,idx+cnt,result+sum);
              
        }
        
    }
}
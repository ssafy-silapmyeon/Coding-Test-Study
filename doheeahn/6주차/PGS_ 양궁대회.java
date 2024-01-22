class Solution {
    static int max =1;
    static int[] answer ={-1};
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        score(info,ryan,0,n);
        return answer;
    }
    
    public void score(int[] info, int[] ryan, int idx, int n){
        if(n<0){
            return;
        }
        if(idx==11){//라이언 0 점까지 화살 분배
            if(n!=0){//n발이 남았어
                ryan[10]=n;//낮은 점수에 맞히기
            }
            int r=0;
            int p=0;
            for(int i=0;i<11;i++){
                if(info[i]<ryan[i]){//라이언 총 점수
                    r+=(10-i);
                }
                else if (info[i]>ryan[i]){//피치 총 점수
                    p+=(10-i);
                }
            }
            if(max<=r-p){//가장 큰 점수차
                if(answer.length==1)
                    answer = new int[11];
                if(max ==r-p){//가장 낮은 점수를 더 많이 맞힌 경우 찾기
                    for(int i=10;i>=0;i--){
                       if(answer[i]>ryan[i]){
                            return;
                        }
                        else if(answer[i]<ryan[i]){
                          break;
                       }
                    }
                }
                max =r-p;
                for(int i=0;i<11;i++){
                    answer[i] = ryan[i];
                }
            }
            return;
        }

        
        for(int i=idx;i<11;i++){
            ryan[i] = info[i]+1;
            score(info,ryan,i+1,n-ryan[i]);
            ryan[i] =0;
            score(info, ryan,i+1,n);   
        }
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1;i<=5000;i++){//세로
            for(int j=1;j<=5000;j++){//가로 - 문제에서 가로가 더 길다고 했음
                if((i-2)* (j-2) == yellow && 2*i+2*j-4==brown){
                    answer[0] = j;
                    answer[1]=i;
                    return answer;
                }
                else if((i-2)* (j-2) > yellow || 2*i+2*j-4 >brown){
                    break;
                }
                
            }
        }
        
        return answer;
    }
}
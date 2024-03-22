import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wh = scores[0].clone();
        
        Arrays.sort(scores, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o2[0] == o1[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o2[0], o1[0]);
            }
        }); 
        
        List<int[]> incentive = new ArrayList<>();
        int max = 0;
        int prev = scores[0][0];
        for(int i=0; i<scores.length; i++){
            if(prev != scores[i][0]){
                max = Math.max(max, scores[i-1][1]);
                prev = scores[i][0];
            }
            
            if(max > scores[i][1]) continue;
            incentive.add(scores[i]);
        }
        
        Collections.sort(incentive, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o2[0]+o2[1], o1[0]+o1[1]);
            }
        });
        
        int rank = 0;
        int ans = -1;
        int sum = -1;
        for(int i=0; i<incentive.size(); i++){
            if(sum != incentive.get(i)[0] + incentive.get(i)[1]){
                rank = i+1;
                sum = incentive.get(i)[0] + incentive.get(i)[1];
            }
            
            if(incentive.get(i)[0] == wh[0] && incentive.get(i)[1] == wh[1]){
                ans = rank;
                break;
            }
        }
        
        return ans;
    }
}

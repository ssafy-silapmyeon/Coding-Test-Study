import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        Set<Integer> origin = new HashSet<>();
        int target = cards.length+1;
        int cnt0 = 0;
        for(int i=0; i<cards.length/3; i++){
            if(origin.contains(target-cards[i])){
                cnt0++;
            }
            origin.add(cards[i]);
        }
        
        Set<Integer> set = new HashSet<>();
        int round = 1;
        int cnt1=0;
        int cnt2=0;
        for(int i=cards.length/3; i<cards.length; i+=2){
            for(int j=i; j<=i+1; j++){
                if(origin.contains(target-cards[j])){
                    cnt1++;
                }else if(set.contains(target-cards[j])){
                    cnt2++;
                }
                set.add(cards[j]);
            }
            
            if(cnt0 >= 1){
                round++;
                cnt0--;
            }else if(cnt1 >= 1 && coin >= 1){
                round++;
                cnt1--;
                coin-=1;
            }else if(cnt2 >= 1 && coin >= 2){
                round++;
                cnt2--;
                coin-=2;
            }else{
                break;
            }
        }
        
        return round;
    }
}

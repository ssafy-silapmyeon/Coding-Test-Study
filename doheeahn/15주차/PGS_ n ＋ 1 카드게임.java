import java.util.*;
class Solution {
    static class Card{
        int n,c;
        
        public Card(int n, int c){
            this.n = n;
            this.c = c;
        }
    }
    public int solution(int coin, int[] cards) {
        int answer = 1;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> init = new HashSet<>();
        PriorityQueue<Card> pq = new PriorityQueue<>((o1,o2)->o1.c-o2.c);
        
        int n = cards.length;
        for(int i=0;i<n/3;i++){
            if(set.contains(cards[i])){
                pq.offer(new Card(cards[i],0));
            }
            else{
                set.add(n+1-cards[i]);
            }
            init.add(cards[i]);
        }
        
        for(int i = n/3;i<n;i+=2){
            for(int j=0;j<2;j++){
                if(set.contains(cards[i+j])){
                    if(init.contains(n+1-cards[i+j])){
                        pq.offer(new Card(cards[i+j],1));
                    }
                    else{
                        pq.offer(new Card(cards[i+j],2));
                    }
                }
                else{
                    set.add(n+1-cards[i+j]);
                }
            }
            
            if(pq.size()==0){//낼카드 없음
                break;
            }
            else{
                Card cur = pq.poll();
                if(coin < cur.c){//낼카드 없음
                    break;
                }
                else{
                    coin -= cur.c;
                    answer++;
                }
            }
            
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    static int w =0; //현재 제일 큰 승리 수
    static int[] answer;
    static ArrayList<Integer> listA;
    static ArrayList<Integer> listB;
    
    public int[] solution(int[][] dice) {
        answer = new int[dice.length/2];
        boolean[] pickA = new boolean[dice.length];

        pick(dice,pickA,0,0);
        return answer;
    }
    
    public int win(int[][] arr){
        Collections.sort(listA);
        Collections.sort(listB);
        
        int acnt =0;
        int bcnt =0;
        int result =0;
        for(int l : listA){
            int s=0;
            int e = listA.size()-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(listB.get(mid)>=l){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            
            acnt += s;
            
            s=0;
            e= listA.size()-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(listB.get(mid)>l){
                    e = mid-1;
                }
                else{
                    s = mid+1;
                }
            }
            bcnt += listA.size()-s;
        }
        
        if(w<acnt){
            w = acnt;
            result =1;
        }
        if(w<bcnt){
            w = bcnt;
            result =2;
        }
        return result;
    }
    public void sum(int[][] dice ,int[][] arr,int a, int b,int cnt){
        if(cnt ==arr[0].length){
            listA.add(a);
            listB.add(b);
            return;
        }
        
        for(int i=0;i<6;i++){
            sum(dice,arr,a+dice[arr[0][cnt]][i],b+dice[arr[1][cnt]][i],cnt+1);
        }
    }


    public void pick(int[][] dice, boolean[] pickA,int p,int s){
        if(p == pickA.length/2){//주사위 선택 완료
            int[][] arr = new int[2][pickA.length/2];
            int a=0;
            int b=0;
            for(int i=0;i<pickA.length;i++){
                if(pickA[i]){
                    arr[0][a] =i;
                    a++;
                }
                else{
                    arr[1][b] = i;
                    b++;
                }
            }
            listA = new ArrayList<>();
            listB = new ArrayList<>();
            sum(dice,arr,0,0,0);
            int result = win(arr);
            if(result==1){
                for(int i=0;i<answer.length;i++){
                    answer[i] = arr[0][i]+1;
                }
            }
            else if(result==2){
                for(int i=0;i<answer.length;i++){
                    answer[i] = arr[1][i]+1;
                }
            }
        }
        
        for(int i=s;i<pickA.length-1;i++){
            if(!pickA[i]){
                pickA[i] = true;
                pick(dice,pickA,p+1,i+1);
                pickA[i] = false;
            }
        }
    }
}
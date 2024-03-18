import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        if(arr.length ==1){
            return answer;
        }
        answer = arr[0]*arr[1]/gcd(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            answer = answer * arr[i]/gcd(arr[i],answer);
        }
        return answer;
    }
    
    public int gcd(int n1, int n2){
        if(n1<n2){
            int tmp = n1;
            n1=n2;
            n2= tmp;
        }
        if(n1%n2 ==0){
            return n2;
        }
        return gcd(n2,n1%n2);
    }
}
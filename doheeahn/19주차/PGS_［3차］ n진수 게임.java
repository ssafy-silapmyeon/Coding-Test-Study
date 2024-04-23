class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num =0;
        String s ="";
        while(s.length() < (t-1)*m+p){
            s += game(num,n);
            num ++;
        }
        
        int idx =p-1;
        for(int i=0;i<t;i++){
            answer += s.substring(idx,idx+1);
            idx += m;
        }
        return answer;
    }
    
    public String game(int num, int n){
        String result = "";
        if(num ==0){
            return "0";
        }
        while(num != 0){
            int m = num %n;
            if(m>=10){
                switch(m){
                    case 10:
                        result = "A"+result;
                        break;
                    case 11:
                        result = "B"+result;
                        break;
                    case 12:
                        result = "C"+result;
                        break;
                    case 13:
                        result = "D"+result;
                        break;
                    case 14 :
                        result = "E"+result;
                        break;
                    case 15:
                        result = "F"+result;
                        break;
                        
                }
                
            }
            else{
                result = Integer.toString(m) + result; 
            }
            
            num = num/n;
        }
        return result;
    }
}
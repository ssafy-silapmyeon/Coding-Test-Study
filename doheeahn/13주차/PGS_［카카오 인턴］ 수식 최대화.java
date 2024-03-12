import java.util.*;
class Solution {
    static char[][] operation = {{'+','-','*'},{'+','*','-'},{'-','+','*'},
                                     {'-','*','+'},{'*','+','-'},{'*','-','+'}};
    public long solution(String expression) {
        long answer = 0;
        for(int i=0;i<6;i++){
            Queue<Long> num = new LinkedList<>();
            Queue<Character> oper = new LinkedList<>();
            for(int l=0;l<expression.length();l++){
                if(expression.charAt(l)=='+'||expression.charAt(l)=='-'||expression.charAt(l)=='*'){
                    oper.offer(expression.charAt(l));
                }
                else{
                    int s = l;
                    while(l < expression.length() && '0'<= expression.charAt(l) && expression.charAt(l)<='9'){
                        l++;
                    }
                    String n = expression.substring(s,l);
                    l--;
                    num.offer(Long.parseLong(n));
                }

            }
            
            for(int j=0;j<3;j++){
                int size = oper.size();
                long ex = num.poll();
                System.out.println(ex);
                for(int t=0;t<size;t++){
                    if(oper.peek() == operation[i][j]){
                        switch(oper.poll()){
                            case '+':
                                ex= ex +num.poll();
                                break;
                            case '-':
                                ex= ex -num.poll();
                                break;
                            case '*':
                                ex= ex *num.poll();
                                break;
                        }
                    }
                    else{
                        num.offer(ex);
                        ex = num.poll();
                        oper.offer(oper.poll());
                    }
                    
                }
                num.offer(ex);//마지막 계산 넣어주기 
            }

            if(answer < Math.abs(num.peek())){
                answer = Math.abs(num.poll());
            }    
        }
        return answer;
    }
}
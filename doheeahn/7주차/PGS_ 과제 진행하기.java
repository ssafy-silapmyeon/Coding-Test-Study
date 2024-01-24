import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        int ans=0;
        //과제 시작 시간 순으로 정렬
        Arrays.sort(plans, (o1,o2)-> o1[1].compareTo(o2[1]));
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(plans[i][1],":");
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(plans[i+1][1],":");
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            
            int d = (h2-h1)*60 + (m2-m1);
            if(d < Integer.parseInt(plans[i][2])){//stack에 과제 저장
                plans[i][2] = Integer.toString(Integer.parseInt(plans[i][2]) - d);
                stack.add(i);
            }
            else{//i과제 완료
                answer[ans] = plans[i][0];
                ans++;
                d -= Integer.parseInt(plans[i][2]);
                //다음 과제 까지 시간 남았는지 확인
                    while(!stack.isEmpty() && d>0){
                        int idx = stack.pop();
                        if(d >= Integer.parseInt(plans[idx][2])){
                            answer[ans] = plans[idx][0];
                            ans++;
                            d -= Integer.parseInt(plans[idx][2]);
                        }
                        else{
                            plans[idx][2] = Integer.toString(Integer.parseInt(plans[idx][2]) - d);
                            stack.add(idx);
                            break;
                        }
                    }
            }    
        }
        answer[ans] = plans[n-1][0];
        ans++;
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[ans] = plans[idx][0];
            ans++;
        }
        
        
        return answer;
    }
}
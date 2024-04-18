class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        if(a>b){
            int tmp=a;
            a=b;
            b=tmp;
        }
        
        int cnt=1;
        while(true){
            if(a%2!=0 && a+1==b){
                System.out.println(a+" "+b);
                answer = cnt;
                break;
            }
            
            a = (a+1)/2;
            b = (b+1)/2;
            cnt++;
        }

        return answer;
    }
}
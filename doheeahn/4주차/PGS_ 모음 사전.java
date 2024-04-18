class Solution {
    static int result =0;
    static int answer =0;
    public int solution(String word) {
        int len = word.length();
        char[] arr = {'A','E','I','O','U'};
        alpha(arr, "", word);

        return answer;
    }
    
    public void alpha(char[] arr, String str, String word){
        if(str.equals(word)){
            answer = result;
            return;
        }
        if(str.length() ==5){
            return;
        }
        for(int i=0;i<5;i++){
            result ++;
            alpha(arr,str+arr[i],word);
        }
    }
}
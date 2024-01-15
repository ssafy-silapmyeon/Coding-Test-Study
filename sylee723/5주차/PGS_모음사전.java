class Solution {
    static int count, answer;
    public int solution(String word) {
        count = 0;
        answer = 0;
        perm("", word);
        
        return answer;
    }
    
    static void perm(String str, String word) {
        if (str.equals(word)) {
            answer = count;
            return;
        }
        count++;
        
        if (str.length() == 5) {
            return;
        }
        perm(str+"A", word);
        perm(str+"E", word);
        perm(str+"I", word);
        perm(str+"O", word);
        perm(str+"U", word);
    }
}
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<phone_book.length;i++){
            set.add(phone_book[i]);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book[i].length();j++){
                String head = phone_book[i].substring(0,j);
                if(set.contains(head)){
                    return false;
                }
            }
        }
        return answer;
    }
}
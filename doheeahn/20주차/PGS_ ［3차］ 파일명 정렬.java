import java.util.*;
class Solution {
    static class File implements Comparable<File>{
        String head,tail;
        int number,idx;
        File(String head, int number,String tail,int idx){
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(File o){
            //head 비교
            if(this.head.equals(o.head)){
                return this.number-o.number;
            }
            else{
                return this.head.compareTo(o.head);
            }    
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        LinkedList<File> pq = new LinkedList<>();
        for(int i=0;i<files.length;i++){
            int s=0;
            String head = "";
            int number = 0;
            String tail = "";
            while(!('0'<=files[i].charAt(s) && files[i].charAt(s)<='9')){
                if('A'<=files[i].charAt(s) && files[i].charAt(s)<='Z'){
                    head += String.valueOf((char)(files[i].charAt(s)+32));
                }
                else{
                    head += String.valueOf(files[i].charAt(s));
                }
                s++; 
            }
            int e = s;
            while(e<files[i].length() && '0'<=files[i].charAt(e) && files[i].charAt(e)<='9' && e-s <5){
                e++;
            }
            number = Integer.valueOf(files[i].substring(s,e));
            tail = files[i].substring(e,files[i].length());
            pq.offer(new File(head,number,tail,i));
        }
        Collections.sort(pq);
        int i=0;
        for(File f:pq){
            answer[i] =files[f.idx]; 
            i++;
        }
        
        
        return answer;
    }
}
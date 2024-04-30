import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<File> pq = new PriorityQueue<>();
        
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int nIdx = 0;
            while (!(file.charAt(nIdx) >= '0' && file.charAt(nIdx) <= '9')) {
                nIdx++;
            }
            
            int tIdx = nIdx;
            while (tIdx < file.length() 
                   && file.charAt(tIdx) >= '0' && file.charAt(tIdx) <= '9') {
                tIdx++;
            }
            
            pq.add(new File(file.substring(0, nIdx), 
                            file.substring(nIdx, tIdx), 
                            file.substring(tIdx), 
                            file, 
                            i));
        }
        
        String[] answer = new String[files.length];
        for (int i = 0; i < answer.length; i++) {
            File file = pq.poll();
            answer[i] = file.name;
        }
        
        return answer;
    }
    
    static class File implements Comparable<File> {
        String head, number, tail, name;
        int order;
        
        public File(String head, String number, String tail, String name, int order) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.name = name;
            this.order = order;
        }
        
        @Override
        public int compareTo(File o) {
            String h1 = this.head.toLowerCase();
            String h2 = o.head.toLowerCase();
            
            if (!h1.equals(h2)) {
                return h1.compareTo(h2);
            } 
            
            int n1 = Integer.parseInt(this.number);
            int n2 = Integer.parseInt(o.number);
            
            if (n1 != n2) {
                return n1 - n2;
            }
            
            return this.order - o.order;
        }
    }
}
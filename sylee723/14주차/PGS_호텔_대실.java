import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Book> pq = new PriorityQueue<>();
        for (int i = 0; i < book_time.length; i++) {
            String[] s = book_time[i][0].split(":");
            String[] e = book_time[i][1].split(":");
            
            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
            pq.add(new Book(start, end));
        }
        
        ArrayList<Integer> room = new ArrayList<>();
        while (!pq.isEmpty()) {
            Book now = pq.poll();
            
            boolean booked = false;
            for (int i = 0; i < room.size(); i++) {
                if (room.get(i) + 10 <= now.start) {
                    room.set(i, now.end);
                    booked = true;
                    break;
                }
            }
            
            if (!booked) {
                room.add(now.end);
            }
        }
        
        int answer = room.size();
        return answer;
    }
    
    static class Book implements Comparable<Book> {
        int start, end;
        
        public Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Book o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
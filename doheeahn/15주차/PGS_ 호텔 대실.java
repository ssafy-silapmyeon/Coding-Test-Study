import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<String[]> queue = new PriorityQueue<>((o1,o2)->o1[1].compareTo(o2[1]));
        Arrays.sort(book_time,(o1,o2)->o1[0].compareTo(o2[0]));
        
        book_time[0] = clean(book_time[0]);
        queue.offer(book_time[0]);
        for(int i=1;i<book_time.length;i++){
            String[] cur = queue.peek();
            if(cur[1].compareTo(book_time[i][0])<=0){
                queue.poll();
            }
            book_time[i]=clean(book_time[i]);
            queue.offer(book_time[i]);

        }
        answer = queue.size();
        return answer;
    }
    
    public String[] clean(String[] room){
        String e = room[1];
        StringTokenizer st = new StringTokenizer(e,":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(m+10>=60){
            m = m+10-60;
            h++;
        }
        else{
            m +=10;
        }
        String hour = Integer.toString(h);
        String min = Integer.toString(m);
        if(hour.length()==1){
            hour ="0"+hour;
        }
        if(min.length() == 1){
            min = "0"+min;
        }
        room[1] = hour+":"+min;
        return room; 
     }
}
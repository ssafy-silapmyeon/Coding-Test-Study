import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] job1, int[] job2) {
                return job1[0] - job2[0];
            }
        });
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int idx = 0;
        int time = 0;
        int answer = 0;
        while (true) {
            if (idx == jobs.length && pq.isEmpty()) {
                break;
            }
            
            if (pq.isEmpty()) {
                time = Math.max(time, jobs[idx][0]);  
            }
            
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            Job now = pq.poll();
            answer += (time - now.start + now.duration); 
            time += now.duration;
        }
        
        answer /= jobs.length;
        return answer;
    }
    
    static class Job implements Comparable<Job> {
        int start, duration;
        
        public Job(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Job o) {
            return this.duration - o.duration;
        }
    }
}
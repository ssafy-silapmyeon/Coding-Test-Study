import java.util.*;

class PGS_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){ //요청시간 오름차순 정렬
                return o1[0] - o2[0];
            }
        });

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<jobs.length; i++){
            queue.add(jobs[i]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){ //소요시간 오름차순 정렬
                return o1[1] - o2[1];
            }
        });

        int end = 0;
        int sum = 0;
        while(!queue.isEmpty()){
            if(pq.isEmpty()) end = queue.peek()[0] > end ? queue.peek()[0] : end;
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] current = queue.poll();
                if(current[0] <= end) pq.add(current);
                else queue.add(current);
            }

            int[] complete = pq.poll();
            sum += end - complete[0] + complete[1];
            end += complete[1];
        }

        while(!pq.isEmpty()){
            int[] complete = pq.poll();
            sum += end - complete[0] + complete[1];
            end += complete[1];
        }

        return sum / jobs.length;
    }
}
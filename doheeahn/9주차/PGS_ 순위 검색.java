import java.util.*;
class Solution {
    static int[] l = {0,8,16};
    static int[] g = {0,4};
    static int[] c = {0,2};
    static int[] f = {0,1};
    static ArrayList<Integer>[] arr = new ArrayList[33];
    static int[] answer;
    static Map<String,Integer> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        map.put("cpp",0);
        map.put("java",8);
        map.put("python",16);
        map.put("backend",0);
        map.put("frontend",4);
        map.put("junior",0);
        map.put("senior",2);
        map.put("chicken",0);
        map.put("pizza",1);
        map.put("-",-1);
        

        for(int i=0;i<33;i++){
            arr[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<info.length;i++){
            StringTokenizer st = new StringTokenizer(info[i]);
            int idx = checkInfo(st.nextToken(), st.nextToken(),st.nextToken(),st.nextToken());
            arr[idx].add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0;i<33;i++){
            Collections.sort(arr[i]);
        }
        
        
        for(int i=0;i<query.length;i++){
            String[] q = query[i].split(" and | ");
            int sum =0;
            for(int j=0;j<4;j++){
                if(map.get(q[j])!=-1){
                    sum += map.get(q[j]);
                }
            }
            dfs(q,0,sum,i);
        }
        
        return answer;
    }
    
    
    public void dfs(String[] q,int idx,int sum,int i){
        if(idx == 4){
            int num = Integer.parseInt(q[4]);
            //이분 탐색
            int s =0;
            int e = arr[sum].size();
            while(s<e){
                int mid = (s+e)/2;
                if(arr[sum].get(mid) < num){
                    s = mid+1;
                }
                else{
                    e = mid;
                }
            }
            
            answer[i] += arr[sum].size()-s;
            return;
        }
        
        else if(idx ==0){//언어
            if(map.get(q[idx])==-1){
                for(int t=0;t<3;t++){
                    dfs(q,idx+1,sum+l[t],i);
                }
            }
            else{
                dfs(q,idx+1,sum,i);
            }
            
        }
        else if(idx ==1){//직무
            if(map.get(q[idx])==-1){
                for(int t=0;t<2;t++){
                    dfs(q,idx+1,sum+g[t],i);
                }
            }
            else{
                dfs(q,idx+1,sum,i);
            }
        }
        else if(idx ==2){//경력
            if(map.get(q[idx])==-1){
                for(int t=0;t<2;t++){
                    dfs(q,idx+1,sum+c[t],i);
                }
            }
            else{
                dfs(q,idx+1,sum,i);
            }
        }
        else{//소울푸드
            if(map.get(q[idx])==-1){
                for(int t=0;t<2;t++){
                    dfs(q,idx+1,sum+f[t],i);
                }
            }
            else{
                dfs(q,idx+1,sum,i);
            }
        }
    }
    public int checkInfo(String l,String g,String c, String f){
        int sum =0;
        sum =sum+ map.get(l) + map.get(g)+map.get(c)+map.get(f);
        return sum;
        
    }
}
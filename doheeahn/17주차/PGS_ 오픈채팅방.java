import java.util.*;
class Solution {
    static class User{
        String id, message;
        
        public User(String id, String message){
            this.id = id;
            this.message = message;
        }
    }
    public String[] solution(String[] record) {

        ArrayList<User> list = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        
        StringTokenizer st;
        for(int i=0;i<record.length;i++){
            st = new StringTokenizer(record[i]);
            String m = st.nextToken();
            String id = st.nextToken();
            if(m.equals("Enter")){
                String name = st.nextToken();
                map.put(id,name);
                list.add(new User(id,"님이 들어왔습니다."));
            }
            else if(m.equals("Leave")){
                 list.add(new User(id,"님이 나갔습니다."));
            }
            else{
                String name = st.nextToken();
                map.put(id,name);
            }
            
        }
        
        String[] answer = new String[list.size()];
        int idx =0;
        for(User u:list){
            String name = map.get(u.id);
            answer[idx] = name + u.message;
            idx++;
        }
        return answer;
    }
}
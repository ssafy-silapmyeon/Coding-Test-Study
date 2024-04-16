import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        function(str1,map1);
        function(str2,map2);
        
        //교집합 구하기
        double i = (double)inter(map1,map2);
        //합집합 구하기
        double u = (double)union(map1,map2);
        double a =0;
        //**합집합 구할때 한개의 map 안에 여러개 있는거 고려 안해서 틀렸음
        if(u !=0){
            a = (i/u) * 65536;
            answer = (int) a;
        }
        
        return answer;
    }
    public int inter(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        int result=0;
        for(Map.Entry<String,Integer> entry1 : map1.entrySet()){
            String s1 = entry1.getKey();
            for(Map.Entry<String,Integer> entry2 : map2.entrySet()){
                String s2 = entry2.getKey();
                if(s1.equalsIgnoreCase(s2)){
                    int n1 = entry1.getValue();
                    int n2 = entry2.getValue();
                    result += Math.min(n1,n2);
                }
            }
        }

        return result;
    }

        public int union(HashMap<String,Integer> map1,HashMap<String,Integer> map2){
        int result=0;
        for(Map.Entry<String,Integer> entry1 : map1.entrySet()){
            String s1 = entry1.getKey();
            boolean c = false;
            for(Map.Entry<String,Integer> entry2 : map2.entrySet()){
                String s2 = entry2.getKey();
                if(s1.equalsIgnoreCase(s2)){
                    int n1 = entry1.getValue();
                    int n2 = entry2.getValue();
                    result += Math.max(n1,n2);
                    c = true;
                    break;
                }
            }
            if(!c){
                result += entry1.getValue();
            }
        }
        for(Map.Entry<String,Integer> entry1 : map2.entrySet()){
            String s1 = entry1.getKey();
            boolean c = false;
            for(Map.Entry<String,Integer> entry2 : map1.entrySet()){
                String s2 = entry2.getKey();
                if(s1.equalsIgnoreCase(s2)){
                    c = true;
                    break;
                }
            }
            if(!c){
                result += entry1.getValue();
            }
        }
        return result;
    }
                
                
                
                
    public void function(String str, HashMap<String,Integer> map){
        
        for(int i=0;i<str.length()-1;i++){
            if(!(('A'<=str.charAt(i) && str.charAt(i)<='Z') || ('a'<=str.charAt(i) && str.charAt(i)<='z'))){
                continue;
            }
            else if(!(('A'<=str.charAt(i+1) && str.charAt(i+1)<='Z') || ('a'<=str.charAt(i+1) && str.charAt(i+1)<='z'))){
                 continue;
            }
            
            String s = str.substring(i,i+2);
            boolean c= false;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                String k = entry.getKey();
                if(k.equalsIgnoreCase(s)){
                    int n = entry.getValue();
                    map.put(k,n+1);
                    c = true;
                    break;
                }
            }
            if(!c){
                map.put(s,1);
            }
        }
    }
}
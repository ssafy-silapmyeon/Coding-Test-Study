import java.util.*;

class Solution {
    static int[] parents;
    static String[] values;
    
    public String[] solution(String[] commands) {
        makeSet();
        values = new String[2500];
        
        List<String> list = new ArrayList<>();
        String[] arr;
        int r, c, num, root;
        for(int i=0; i<commands.length; i++){
            arr = commands[i].split(" ");
            switch(arr[0]){
                case "UPDATE":
                    if(arr.length == 4){
                        r = Integer.parseInt(arr[1])-1;
                        c = Integer.parseInt(arr[2])-1;
                        num = r * 50 + c;
                        root = findSet(num);
                        values[root] = arr[3];
                    }else{
                        for(int j=0; j<values.length; j++){
                            if(values[j] != null && values[j].equals(arr[1])){
                                values[j] = arr[2];
                            }
                        }
                    }
                    
                    break;
                case "MERGE":
                    r = Integer.parseInt(arr[1])-1;
                    c = Integer.parseInt(arr[2])-1;
                    num = r * 50 + c;
                    int A = findSet(num);
                    
                    r = Integer.parseInt(arr[3])-1;
                    c = Integer.parseInt(arr[4])-1;
                    num = r * 50 + c;
                    int B = findSet(num);
                    
                    union(A, B);
                    break;
                case "UNMERGE":
                    r = Integer.parseInt(arr[1])-1;
                    c = Integer.parseInt(arr[2])-1;
                    num = r * 50 + c;
                    root = findSet(num);
                    
                    if(num != root){
                        values[num] = values[root];
                        values[root] = null;
                    }
                    
                    List<Integer> delete = new ArrayList<>();
                    for(int j=0; j<2500; j++){
                        if(findSet(j) == root){
                            delete.add(j);
                        }
                    }
                    
                    for(int n : delete){
                        parents[n] = n;
                    }
                    
                    break;
                case "PRINT":
                    r = Integer.parseInt(arr[1])-1;
                    c = Integer.parseInt(arr[2])-1;
                    num = r * 50 + c;
                    
                    root =findSet(num);
                    list.add(values[root]);
                    break;
            }
        }
        
        String[] ans = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i) == null ? "EMPTY" : list.get(i);
        }
        
        return ans;
    }
    
    static void makeSet(){
        parents = new int[2500];
        for(int i=0; i<2500; i++){
            parents[i] = i;
        }
    }
    
    static int findSet(int p){
        if(parents[p] == p){
            return p;
        }
        return parents[p] = findSet(parents[p]);
    }
    
    static void union(int rootA, int rootB){
        if(rootA == rootB){
            return;
        }
        
        if(values[rootA] != null){
            parents[rootB] = rootA;
            values[rootB] = null;
        }else if(values[rootB] != null){
            parents[rootA] = rootB;
        }else{
            parents[rootB] = rootA;
        }
    }
}

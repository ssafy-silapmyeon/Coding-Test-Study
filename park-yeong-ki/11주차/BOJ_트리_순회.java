import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Character, List<Character>> map;
    static StringBuilder preorder = new StringBuilder();
    static StringBuilder inorder = new StringBuilder();
    static StringBuilder postorder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        char root, left, right;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            root = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);

            map.put(root, new ArrayList<>());
            map.get(root).add(left);
            map.get(root).add(right);
        }

        dfs('A');

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
    }

    static void dfs(char node) {
        preorder.append(node);
        for (int i = 0; i < map.get(node).size(); i++) {
            if (i == 1) inorder.append(node);
            if (map.get(node).get(i) == '.') continue;
            dfs(map.get(node).get(i));
        }
        postorder.append(node);
    }
}

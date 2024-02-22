import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        Map<Character, Integer> score = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                score.put(words[i].charAt(j), score.getOrDefault(words[i].charAt(j), 0) + (int) Math.pow(10, words[i].length() - 1 - j));
            }
        }

        List<Character> alphabet = new ArrayList<>(score.keySet());
        Collections.sort(alphabet, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(score.get(o2), score.get(o1));
            }
        });

        int num = 9;
        for (char key : alphabet) {
            score.put(key, num--);
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                ans += score.get(words[i].charAt(j)) * Math.pow(10, words[i].length() - 1 - j);
            }
        }
        System.out.println(ans);
    }
}

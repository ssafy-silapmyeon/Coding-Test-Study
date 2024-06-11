import java.io.*;
import java.util.*;

public class Main {
    static char[][] table;
    static Map<Character, Point> tableData;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String key = br.readLine();

        makeTable(key);
        ArrayList<Character> dMsg = divideMsg(msg);
        String answer = encrypt(dMsg);

        System.out.println(answer);
    }

    static void makeTable(String key) {
        boolean[] used = new boolean[26];
        table = new char[5][5];
        tableData = new HashMap<>();
        
        used['J' - 'A'] = true;
        int idx = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!used[ch - 'A']) {
                table[idx / 5][idx % 5] = ch;
                tableData.put(ch, new Point(idx / 5, idx % 5));
                used[ch - 'A'] = true;
                idx++;
            }
        }

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                table[idx / 5][idx % 5] = (char)('A' + i);
                tableData.put((char)('A' + i), new Point(idx / 5, idx % 5));
                idx++;
            }
        }
    }

    static ArrayList<Character> divideMsg(String msg) {
        int i = 0;
        ArrayList<Character> result = new ArrayList<>();
        char ch1, ch2;
        while (i < msg.length()) {
            ch1 = msg.charAt(i);
            result.add(ch1);
            
            if (i + 1 == msg.length()) {
                result.add('X');
                break;
            }

            ch2 = msg.charAt(i + 1);
            if (ch1 != ch2) {
                result.add(ch2);
                i += 2;
            } else if (ch1 == 'X') {
                result.add('Q');
                i++;
            } else {
                result.add('X');
                i++;
            }
        }

        return result;
    }

    static String encrypt(ArrayList<Character> dMsg) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < dMsg.size(); i += 2) {
            char ch1 = dMsg.get(i);
            char ch2 = dMsg.get(i + 1);

            Point p1 = tableData.get(ch1);
            Point p2 = tableData.get(ch2);

            int r1, r2, c1, c2;
            if (p1.i == p2.i) {
                r1 = r2 = p1.i;
                c1 = (p1.j + 1) % 5;
                c2 = (p2.j + 1) % 5;
            } else if (p1.j == p2.j) {
                c1 = c2 = p1.j;
                r1 = (p1.i + 1) % 5;
                r2 = (p2.i + 1) % 5;
            } else {
                r1 = p1.i;
                r2 = p2.i;
                c1 = p2.j;
                c2 = p1.j;
            }

            sb.append(table[r1][c1]);
            sb.append(table[r2][c2]);
        }

        return sb.toString();
    }
    
    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }
}

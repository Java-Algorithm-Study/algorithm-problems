import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine().toUpperCase();
        var obj = new HashMap<String, Integer>();
        for (int i = 0; i < line.length(); i++) {
            String word = Character.toString(line.charAt(i));
            Integer count = obj.get(word);
            if (count == null) {
                obj.put(word, 1);
            } else {
                obj.put(word, count + 1);
            }
        }
        int max = 0;
        String str = "";
        for (String key : obj.keySet()) {
            if (obj.get(key) > max) {
                max = obj.get(key);
                str = key;
            }
        }
        int helper = 0;
        for (Integer num : obj.values()) {
            if (max == num) {
                helper++;
            }
        }
        String answer = (helper >= 2) ? "?" : str;
        System.out.println(answer);
    }
}

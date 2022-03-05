import java.util.HashMap;
import java.util.Scanner;

public class Boj_10808 {
    static int A = 26; //알파벳 개수
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < A; i++) {
            hm.put((char)(97 + i), 0);
        }
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        char [] input = sc.nextLine().toCharArray();

        for (char ch : input)
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

        for (char key : hm.keySet()) {
            int value  = hm.get(key);
            sb.append(value + " ");
        }
        System.out.println(sb);
    }
}
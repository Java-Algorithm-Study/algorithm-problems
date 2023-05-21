package language.java.Baek;

import java.util.HashMap;
import java.util.Scanner;

public class Boj_10809 {
    static int A = 26; //알파벳 개수
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < A; i++) {
            hm.put((char)(97 + i), -1);
        }
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        char [] input = sc.nextLine().toCharArray();

//        for(char a: input.toCharArray()) {
//            hm.put(a,  hm.get(a) == -1 ? input.indexOf(a) : hm.get(a));
//        } -> 딱히 큰 차이 없는 코드다..

        for (int i = 0; i < input.length; i++) {
            int j = hm.get(input[i]);
            hm.put(input[i],  j == -1 ? i : j);
        }
        for (char key : hm.keySet()) {
            int value  = hm.get(key);
            sb.append(value + " ");
        }
        System.out.println(sb);
    }
}
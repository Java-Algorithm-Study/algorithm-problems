package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_11899 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int sum = 0;
        Stack<Integer> sk = new Stack<Integer>();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                sk.push(0);
            } else {
                if (sk.empty()) {
                    sum++;
                } else {
                    sk.pop();
                }
            }
        }
        System.out.println(sum + sk.size());

    }
}

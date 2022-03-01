import java.util.Scanner;
import java.util.Stack;

public class boj_11899 {
    public static void main(String[] args) {
        solving();
    }

    public static void solving() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        for (char ch : str.toCharArray()) {
            switch(ch) {
                case '(' :
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty()) cnt++;
                    else stack.pop();
                    break;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(cnt);
        }
        else {
            cnt += stack.size();
            System.out.println(cnt);
        }
    }
}
package language.java.Programmers;

import java.util.*;

public class Pro_68935 {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while(n != 0) {
            stk.add(n % 3);
            n = n / 3;
        }

        int i = 0;
        while (!stk.isEmpty()) {
            answer +=  stk.pop() * Math.pow(3, i++);
        }

        return answer;
    }
}

package language.java.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Pro_17681 {
    static public String[] solution2(int n, int[] arr1, int[] arr2) {

        String [] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

        }

        for (int i = 0; i < n; i++) {
            int zeroCnt = n - answer[i].length();
            String zero = "";
            while(zeroCnt-- > 0) {
                zero += "0";
            }
            answer[i] = zero + answer[i];
        }

        for (int i = 0; i < n; i++) {
            answer [i] = answer[i].replace('1', '#');
            answer [i] = answer[i].replace('0', ' ');
        }

        return answer;
    }
    static int N;
    // 10 -> 2
    public static String converting2to10(int n) {
        int num = n;
        Stack<Integer> stk = new Stack<>();
        while (num > 0) {
            int target = (num % 2);
            num = num / 2;
            stk.push(target);
        }

        String result = "";
        if (stk.size() != N) {
            int gap = N - stk.size();
            while(gap-- > 0) result += "0";
        }

        while(!stk.isEmpty()) {
            result += stk.pop();
        }
        return result;
    }

    public static String combineBoardLine (String a, String b) {
        String result = "";
        String [] chA = a.split("");
        String [] chB = b.split("");
        for (int i = 0; i < N; i++) {
            int wordA = Integer.parseInt(chA[i]);
            int wordB = Integer.parseInt(chB[i]);
            if(wordA+wordB > 0) result += "#";
            else result += " ";
        }
        return result;
    }

    public String[] solution1(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        N = n;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(converting2to10(arr1[i]));
            list2.add(converting2to10(arr2[i]));
        }

        for (int i = 0; i < n; i++) {
            answer[i] = combineBoardLine(list1.get(i), list2.get(i));
        }
        return answer;
    }
}

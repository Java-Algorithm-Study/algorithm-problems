
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 단어뒤집기

public class Boj_17413 {
    public static void main(String[] args) throws IOException {

        Queue<Character> qu = new LinkedList<>();
        Stack<Character> st = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        input = input + ' '; // * 중요

        boolean flag = false;

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '<') {
                while(!st.isEmpty())  sb.append(st.pop());
                flag = true;
            }

            if(flag) {
                qu.add(input.charAt(i));
                if(input.charAt(i) == '>') {
                    while(!qu.isEmpty())   sb.append(qu.poll());
                    flag = false;
                }
            }else {
                if(input.charAt(i) == ' ') {
                    while(!st.isEmpty())  sb.append(st.pop());
                    sb.append(' ');
                }else {
                    st.add(input.charAt(i));
                }
            }
        }
        System.out.print(sb);
    }
}

/*

히든테이스 케이스 때문에 틀렸습니다.



import java.util.LinkedList;
import java.util.qu;
import java.util.Scanner;
import java.util.st;

public class Main {
    public static void main(String[] args) {

        qu<String> qu = new LinkedList<>();
        st<String> sk = new st<>();
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char [] ch = input.toCharArray();

         if (ch[0] != '<')  {
             for (int i = 0; i < ch.length; i++) {
                if (ch[i] == ' ') {
                    while (!sk.isEmpty())sb.append(sk.pop());
                    sb.append(' ');
                }else {
                    sk.push(String.valueOf(ch[i]));
                }
             }
             while (!sk.isEmpty())sb.append(sk.pop());
         }else {
             for (int i = 0; i < ch.length; i++) {
                 if (ch[i] != '>') {
                     if (qu.isEmpty()) {
                         if (qu.isEmpty() && ch[i] =='<') {
                             if (!sk.isEmpty()) while(!sk.isEmpty()) sb.append(sk.pop());
                             qu.offer(String.valueOf(ch[i]));
                         } else {
                             if (ch[i] == ' ') {
                                 while (!sk.isEmpty())sb.append(sk.pop());
                                 sb.append(' ');
                             }else {
                                 sk.push(String.valueOf(ch[i]));
                             }

                             if (ch[i] == '<' && !sk.isEmpty()) sb.append(sk.pop());
                         }

                     }else {
                         qu.offer(String.valueOf(ch[i]));
                     }
                 }else if (ch[i] == '>') {
                     while(!qu.isEmpty()) sb.append(qu.poll());
                     sb.append('>');
                 }
             }
         }


        if (!sk.isEmpty()) while (!sk.isEmpty()) sb.append(sk.pop());
        System.out.println(sb);
    }
}

*/
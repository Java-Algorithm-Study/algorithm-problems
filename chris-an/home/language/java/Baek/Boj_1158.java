package language.java.Baek;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1158 {

    /*
        요세푸스 순열 문제
    */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Queue<Integer> qu = new LinkedList<Integer>();

        int people = sc.nextInt();
        int order = sc.nextInt();

        sb.append("<");

        for (int i = 1; i <= people; i++) {
            qu.offer(i);
        }

        for (int i = 0; i < people-1; i++) {
            for (int j = 0; j < order-1; j++) {
                qu.offer(qu.poll());
            }
            sb.append(qu.poll()).append(", ");
        }

        sb.append(qu.poll()).append(">");
        System.out.println(sb);
    }
}

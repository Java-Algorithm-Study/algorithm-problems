package language.java.Baek;

import java.util.Scanner;

public class Boj_10430 {
    static int operatorType1 (int a, int b, int c) {
        return (a+b)%c;
    }
    static int operatorType2 (int a, int b, int c) {
        return ((a%c) + (b%c))%c;
    }
    static int operatorType3 (int a, int b, int c) {
        return (a*b)%c;
    }
    static int operatorType4 (int a, int b, int c) {
        return ((a%c) * (b%c))%c;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String [] operator = sc.nextLine().split(" ");
        int a = Integer.parseInt(operator[0]);
        int b = Integer.parseInt(operator[1]);
        int c = Integer.parseInt(operator[2]);
        System.out.println(operatorType1(a, b, c));
        System.out.println(operatorType2(a, b, c));
        System.out.println(operatorType3(a, b, c));
        System.out.println(operatorType4(a, b, c));
    }
}

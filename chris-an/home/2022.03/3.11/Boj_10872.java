import java.util.Scanner;

public class Boj_10872 {

    static int value = 1;
    public static int factorial(int n) {
        if (n == 0) return value;
        value *= n ;
        return factorial(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(factorial(sc.nextInt()));
    }
}

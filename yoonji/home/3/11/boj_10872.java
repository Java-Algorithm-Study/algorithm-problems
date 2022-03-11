import java.util.Scanner;
// 팩토리얼
public class boj_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(facto(sc.nextInt()));
    }

    private static int facto(int n) {
        if (n<=1) return 1;
        return facto(n - 1) * n;
    }
}

import java.util.Scanner;
// 코드길이 감소. 메모리 조금 감소. 시간 조금 증가
public class boj_1676_recursion {
    static int cnt_2 = 0;
    static int cnt_5 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        facto(sc.nextInt());
        System.out.println(Math.min(cnt_2, cnt_5));
    }
    private static void facto(int n) {
        int tmp = n;
        if (tmp<=1) return;
        while (tmp % 2 == 0)  {
            tmp /= 2;
            cnt_2++;
        }
        while (tmp % 5 == 0)  {
            tmp /= 5;
            cnt_5++;
        }
        facto(n - 1);
    }
}

import java.util.Scanner;

// 뒷자리에서부터 0이 아닌 숫자가 나올 때까지의 0의 갯수
// 뒷자리가 0이 나오려면 * 10, 즉 2 * 5가 약수로 있다.
// 0이 한개 더 늘어날 때마다 *10이 늘어나는 것
// 2와 5가 포함된 갯수만큼 0이 있는 것.

// 수정 : 500까지의 팩토리얼을 구하는 경우, 항상 5보다 2가 더 많은 횟수로 곱해지기에, cnt_5가 항상 최솟값이 된다. 2와 5를 나눠 cnt해서 비교할 필요가 없다.
// ex) 5! = 5*4*3*2*1 = 5*2*2*2*3*1
public class boj_1676 {
    public static void main(String[] args) {
//        int cnt_2 = 0;
        int cnt_5 = 0;
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        for (int i=2; i<=N; i++) {  // 팩토리얼 N! == N부터 1까지 순회하여 곱함. 각 수에서 2와 5로 나누어 떨어지는 경우를 ++하고,
            int n = i;
            /*while (n % 2 == 0)  {
                n /= 2;
                cnt_2++;
            }*/
            while (n % 5 == 0)  {   // 위 반복에서 2로 나눈 값에서 5로 나눠지는 경우는 10 한번
                n  /=5;
                cnt_5++;
            }
        }
        // 두 수중 최솟값에 맞추면 10이 몇번 곱해졌는지 알 수 있음 ex) cnt_2=8, cnt_5=2 => 10이 2번 곱해진 것.
//        System.out.println(Math.min(cnt_2, cnt_5));
        System.out.println(cnt_5);
    }
}

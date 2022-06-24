import java.util.Scanner;

public class Boj_11729 {
    static StringBuilder sb = new StringBuilder();
    static int cnt;

    public static void hanoi(int nDisks, int fromPeg, int toPeg) {
        if (nDisks == 1) {
            move(fromPeg, toPeg);
            return;
        } else {
            int helpPeg = 6 - fromPeg - toPeg;
            hanoi(nDisks - 1, fromPeg, helpPeg);
            move(fromPeg, toPeg);
            hanoi(nDisks - 1, helpPeg, toPeg);
        }
    }

    public static void move (int fromPeg, int toPeg) {
        sb.append(fromPeg).append(' ').append(toPeg).append('\n');
        cnt++;
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
}

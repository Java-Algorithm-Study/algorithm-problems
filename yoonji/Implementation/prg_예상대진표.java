package Implementation;
//import java.util.*;
// 토너먼트에 의해 1/2로 줄어 드니까
// 1~2 3~4 5~6 7~8
//  1   2   3   4   가 되어야함. 즉, 2로 나누는데 홀수의 경우 +1을 해야 새 번호가 잘 부여됨.
// 1~2 3~4
//  1   2
//    1     결국 a와 b가 게임에서 만난 라운드까지 구하려면, 두 a,b가 같은 값으로 모아지는 순간에 종료한다.
public class prg_예상대진표 {
    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            round++;
            if (a%2==1) a++;
            if (b%2==1) b++;
            a/=2;
            b/=2;
        }
        return round;
    }
    /*public int firstTry(int n, int a, int b)
    {
        int answer = 0;
        List<Character> list = new ArrayList<>(n);
        for (int i=1; i<=n; i++) {
            if (i==a) list.add('A');
            else if (i==b) list.add('B');
            else list.add((char)(i+'0'));
        }
        // System.out.println(list);
        // 2씩 끊으면서 값 제거하기 (뒤에서부터 제거해야 인덱스 변동X)
        int round = 0;
        while(list.size()>=2) {
            round++;
            // System.out.println("라운드 "+round+":");
            int lastIdx= list.size()-1;
            for (int i=lastIdx; i>=0; i-=2) {
                char compareFirst = list.get(i-1);
                char compareSec = list.get(i);
                // A와 B가 겨루면 끝.
                if ((compareFirst == 'A' && compareSec=='B') || (compareFirst == 'B' && compareSec=='A'))
                    return round;
                if (compareSec == 'A' || compareSec == 'B') list.remove(i-1); // 두 값중 앞에 것을 제거
                    // else if (list.get(i-1) =='A' || list.get(i-1) == 'B') list.remove(i);
                else list.remove(i);
                // System.out.println(list);
            }
        }
        return round;
    }*/
}

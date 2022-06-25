import java.io.*;

/**
 * 수 정렬하기3 (10989)
 * https://www.acmicpc.net/problem/10989
 *
 * 메모리, 시간 복잡도를 잘 고려해서 코드 구현을 해야합니다.
 * 입력 되는 수의 범위는 1~10000 입니다.
 *
 * 이 문제는 두 가지 방법이 있습니다.
 * Collections.sort 시, 메모리 초과가 될 것입니다.
 * 그래서
 * 첫 번째로는 Arrays.sort 로 하면 힘겹게 통과가 됩니다
 * 하지만, 시간 복잡도 측면에서 두 번째보다 효율이 좋지 않습니다.
 * 두 번째 방법은 아래와 같이 Counting sort 입니다.
 * 이렇게 했을 시, 시간효율이 Arrays.sort 보다도 좋게 나옵니다.
 *
 * 단, 입력 받는 수의 범위가 크다면? 효율이 좋지 않을 겁니다. 약 100만.. 추정?
 *
 * Arrays.sort => M : 36만대, T : 2400대
 * Counting sort => M : 33만대, T : 1600대
 */
public class Boj_10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count[] = new int[10001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++; // 입력 받은 수를 idx 로 count 배열로 ++
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) { // ==> while (count[i]-- > 0)
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}

/*
    [ Arrays. sort ]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] inputData = new int[N];
        for (int i = 0; i < N; i++) inputData[i] = Integer.parseInt(br.readLine());

        Arrays.sort(inputData);
        StringBuilder sb = new StringBuilder();
        for (int i : inputData) {
           sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
*/

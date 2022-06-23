import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numberCard = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numberCard[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] keyArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) keyArr[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(numberCard);

        // result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) sb.append(binarySearch2(keyArr[i], 0, numberCard.length - 1, numberCard)).append(' ');
        System.out.println(sb);
    }

    // 재귀적 탐색
    private static int binarySearch(int key, int low, int high, int[] numberCard) {
        int mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (numberCard[mid] == key) return 1;
            else if (numberCard[mid] > key) return binarySearch(key, low, mid - 1, numberCard);
            else return binarySearch(key, mid + 1, high, numberCard);
        }

        return 0;
    }

    // 반복적 탐색
    private static int binarySearch2(int key, int low, int high, int[] numberCard) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == numberCard[mid]) return 1;
            else if (key < numberCard[mid]) high = mid -1;
            else low = mid + 1;
        }

        return 0;
    }
}

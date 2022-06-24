import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_10816_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> numberCardArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numberCardArr.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> keyArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) keyArr.add(Integer.parseInt(st.nextToken()));

        Collections.sort(numberCardArr);
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            while (binarySearch(keyArr.get(i), 0, numberCardArr.size(), numberCardArr)) {
                result[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static boolean binarySearch(int key, int low, int high, ArrayList<Integer> numberCardArr) {
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (numberCardArr.get(mid) == key) {
                numberCardArr.remove(mid);
                return true;
            }else if (key <= numberCardArr.get(mid)) high = mid;
            else low = mid + 1;
        }
        return false;
    }
}

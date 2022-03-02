import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// StringBuilder에 입력
// ArrayList : 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 모두 앞으로 1씩 당겨진다.
public class boj_1158 {
    public static void main(String[] args) throws IOException {
        solving();
    }
    static List<Integer> list = new ArrayList<>();

    private static void solving() throws IOException {
        // 1. N K 를 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("<");
        String[] input = br.readLine().split(" ");

        int pplNum = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int nowIdx = K-1;
        // 2. 1번부터 N까지의 정수를 입력한다.
        for (int i = 1; i <= pplNum; i++) list.add(i);

        int deletedNum;
        int lastIdx;
        // 3. 배열이 빌 때까지 반복한다. (while문)
        while (list.size() > 1) {
            // 4. K번째 인덱스 제거
            lastIdx = list.size() -1;
            if (nowIdx < lastIdx) deletedNum = remove(nowIdx);

            // 4-1. 길이가 인덱스 길이보다 큰 경우
            else if (nowIdx > lastIdx) {
                nowIdx = nowIdx - list.size();   // 길이만큼 빼기
                if (nowIdx <= lastIdx) deletedNum = remove(nowIdx); // 현재 인덱스보다 작거나 같으면 제거 실행
                else continue;  // 여전히 크면 continue
            }
            // 4-2. 인덱스가 같은 경우
            else {
                deletedNum = remove(nowIdx);
            }
            // 5. sb에 추가하고 인덱스 +K을 한다.
            sb.append(deletedNum).append(", ");
            nowIdx = nowIdx + K - 1;   // size가 1 작아지므로 index도 -1을 빼준다.
        }
        // 6. 마지막 원소와 함께 닫아준다.
        sb.append(list.get(0)).append(">");
        System.out.println(sb);
    }

    private static int remove(int nowIdx) {
        return list.remove(nowIdx);
    }
}

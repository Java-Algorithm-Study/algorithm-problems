import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * [11652] 카드 
 * https://www.acmicpc.net/problem/11652
 *
 * -아이디어
 * 1. 가장 많이 나온 카드 값을 출력하고, 횟수가 똑같다면 작은 값을 출력해야 한다.
 * 2. 카드 값을 오름차순으로 정렬해서 횟수만 비교한다.
 *
 * -자료 구조
 * 1. TreeMap : 입력
 */

public class Boj11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            Long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long ans = 0L;
        for (Map.Entry<Long, Integer> x : map.entrySet()) {
            if (max < x.getValue()) {
                max = x.getValue();
                ans = x.getKey();
            }
        }
        System.out.println(ans);
    }
}

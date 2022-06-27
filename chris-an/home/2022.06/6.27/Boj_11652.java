import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 2022.06.23
 * https://www.acmicpc.net/problem/11652
 * sorting - 카드
 *
 자로형 범위
 ◇ int
 -2(31) ~ 2(31)-1
 ◇ long
 -2(63) ~ 2(63)-1
 *
 *  일단 수의 범위가 너무 큰 관계로 Counting sort 는 효율이 좋지 못하다.
 *  이 문제는 HashMap 으로 풀 수 있지 않을까?
 *  getOrDefault 로 10000 개의 값을 가지고 가장 높은 value를 가진 key를 출력하는 방식
 *
 *  Long !!!!!!!!!!!
 */
public class Boj_11652 {
    public static int strToInt(String input) {
        return Integer.parseInt(input);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = strToInt(br.readLine());
        Map<Long, Integer> inputArr = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long key = Long.parseLong(br.readLine());
            inputArr.put(key, inputArr.getOrDefault(key, 0) + 1);
        }

        // 많은 수 뽑기
        long max = Long.MIN_VALUE;
        for (long i : inputArr.keySet()) {
            if (inputArr.get(i) > max) {
                max = inputArr.get(i);
            }
        }

        // 가장 작은 값 뽑기
        List<Long> list = new ArrayList<>();
        for (long i : inputArr.keySet()) {
            if (inputArr.get(i) == max) {
                list.add(i);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}

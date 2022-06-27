import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [1377] 버블 소트
 * https://www.acmicpc.net/problem/1377
 *
 * -아이디어
 * 1. 문제에서 출력해야 되는 값은 버블 정렬을 몇 번 돌아야 오름차순으로 정렬되는지.
 * 2. 입력을 받을 때 값과 들어오는 순서를 Class를 생성해서 list에 넣는다.
 * 3. list를 오름차순으로 정렬하고, 정렬된 순서랑 기존 순서를 비교해서 최대값을 찾는다.
 *
 * -자료 구조
 * 1. Number Class : 값, 순서 저장
 * 
 */

public class Boj1377 {
    static class Number {
        int num;
        int order;

        public Number(int num, int order) {
            this.num = num;
            this.order = order;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Number> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(new Number(Integer.parseInt(br.readLine()), i));
        }

        Comparator<Number> nc = new Comparator<>() {
            @Override
            public int compare(Number n1, Number n2) {
                return n1.num - n2.num;
            }
        };

        Collections.sort(numbers, nc);

        int max = 0;
        for (int i = 0; i < numbers.size(); i++) {
            max = Math.max(max, numbers.get(i).order - i);
        }

        System.out.println(max);
    }
}

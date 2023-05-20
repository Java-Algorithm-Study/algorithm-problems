package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 15. 세 수의 합 (https://leetcode.com/problems/3sum/)
 * 조건. 중복되는 숫자를 사용할 수 없다.
 * 팁. 정렬된 상태에서 0부터 이동시키는 고정값이 중복인 값에 대해서는 건너뛸 수 있다. (앞에서 이미 계산한 것과 계산 중복일테니)
 */
public class leetCode_15_array {
    public List<List<Integer>> solution(int[] arr) {
        Arrays.sort(arr);
        // 리스트 속 배열로 리턴해야한다면 : List<int[]> answers = new ArrayList<>();
        List<List<Integer>> answers = new ArrayList<>();

        // 투 포인터 + 고정 값이 있는! => 쓰리 포인터
        // left는 고정값 i의 바로 뒤!
        for (int i=0; i< arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1]) {
                continue;
            }
            int left = i+1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < 0) {
                    left++;
                }
                else if (sum > 0) {
                    right--;
                }
                else {
                    List<Integer> answer = new ArrayList<>();
                    answer.add(arr[i]);
                    answer.add(arr[left]);
                    answer.add(arr[right]);
                    answers.add(answer);

                    while (left < right && arr[left] == arr[left+1]) {
                        left++;
                    }
                    while (right > left && arr[right] == arr[right-1]) {
                        right--;
                    }
                    // 한번더 옮겨야 다른 값이 나옴.
                    left++;
                    right--;
                }
            }
        }

//        return answers.toArray(new int[answers.size()][3]);
        return answers;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int[] arr2 = {0, 1, 1};
        int[] arr3 = {0, 0, 0};
        leetCode_15_array t = new leetCode_15_array();
        List<List<Integer>> answers = t.solution(arr3);
        for (List<Integer> answer : answers) {
            for (Integer num : answer) {
                System.out.print(num);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}

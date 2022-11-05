/**
 * [12977] 소수 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 *
 * -아이디어
 * 1. nums 배열에서 3개씩 뽑는다.
 * 2. 뽑은 원소 합으로 소수 판별
 *
 */

public class Pro12977 {
    public static void main(String[] args) {

    }

    private int answer = 0;

    public int solution(int[] nums) {
        int[] arr = new int[3];
        dfs(0, 0, arr, nums);

        return answer;
    }

    private void dfs(int count, int start, int[] arr, int[] nums) {
        if (count == 3) {
            int sum = 0;
            for (int x : arr) {
                sum += x;
            }
            if (isPrime(sum)) {
                answer++;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            arr[count] = nums[i];
            dfs(count + 1, i + 1, arr, nums);
        }
    }

    private boolean isPrime(int sum) {
        if (sum < 2) {
            return false;
        }

        for (int i = 2; i * i <= sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }

        return true;
    }
}

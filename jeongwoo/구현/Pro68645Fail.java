import java.util.Arrays;

public class Pro68645Fail {
    private static Integer[] numbers;
    public static void main(String[] args) {
        solution(6);
    }


    public static int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];

        numbers = new Integer[n * (n+1) / 2 + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 2;

        int start = 1;

        for (int i = 0; i < n; i++) {
            int end = start + (n - i - 1);
            if (i % 3 == 0) {
                topToDown(start, end, i);
            }
            else if (i % 3 == 1) {
                leftToRigth(start, end, i, n);
            }
            else {
                downToTop(start, end, i, n);
            }
            start += (n - i);
        }



        for (int i = 1; i < numbers.length; i++) {
            answer[i-1] = numbers[i];
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    private static void topToDown(int start, int end, int x) {
        int temp;
        if (start == 1) {
            start = start + 1;
            temp = 1;
        }
        else {
            temp = (x / 3) * 2;
        }
        for (int i = start; i <= end; i++) {
            int idx = Arrays.asList(numbers).indexOf(i-1);
            numbers[idx + (temp++)] = i;
        }
    }

    private static void leftToRigth(int start, int end, int x, int n) {
        int idx = Arrays.asList(numbers).indexOf(n - (x / 3)) + (x/3 + 1);
        for (int i = start; i <= end; i++) {
            numbers[idx++] = i;
        }
    }

    private static void downToTop(int start, int end, int x, int n) {
        int tempIdx = n - (x / 3);
        for (int i = start; i <= end; i++) {
            int idx = Arrays.asList(numbers).indexOf(i - 1);
            numbers[idx - (tempIdx--)] = i;
        }
    }
}

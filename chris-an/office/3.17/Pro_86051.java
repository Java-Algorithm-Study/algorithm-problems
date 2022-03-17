public class Pro_86051 {

    // 없는 숫자 더하기
    // 0부터 9까지 숫자 중 일부가 들어있는 정수 배열 numbers 가 매개변수로 주어집니다.
    // numbers 에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록
    // solution 함수를 완성해주세요.

    static boolean [] chk = new boolean[10]; // 0~9
    public static int solution(int [] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            chk[numbers[i]] = true;
        }

        int cnt = 0;
        for (boolean bl : chk) {
            if (!bl) {
                answer += cnt;
            }
            cnt++;
        }

        return answer;
    }


    static int N = 45; // 0~9까지 더한 수
    public static int solution2(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) N -= numbers[i];
        return N;
    }

    public static void main(String[] args) {
        int [] testCase1 = {1,2,3,4,6,7,8,0};
        int [] testCase2 = {5,8,4,0,6,7,9};
        //System.out.println(solution(testCase1));
        //System.out.println(solution2(testCase1));
        System.out.println(solution2(testCase2));
    }
}

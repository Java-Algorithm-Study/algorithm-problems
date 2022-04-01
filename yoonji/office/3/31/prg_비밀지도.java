public class prg_비밀지도 {
    private int[][] arr;
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        arr = new int[n][n];    // 0으로 초기화되므로 길이 n에 상관없이 연산 가능.
        // 1. arr1, arr2 배열에 동시 방문하여 이진법 변환 (0과 1로 세팅)
        for (int i = 0; i < n; i++) {
            set(n, arr1[i], arr2[i], i);
        }
        // 2. #과 " " append
        for (int i = 0; i < n; i++) {
            var sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(convert(arr[i][j]));
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
    public void set(int n, int n1, int n2, int i) {
        // 1-1. 두 arr에서 전달된 n 중 1개라도 0이 아닐 때까지 진행
        while (n1 != 0 || n2 != 0) {
            if (n1 % 2 == 0 && n2 % 2 == 0) arr[i][--n] = 0;
            else arr[i][--n] = 1;
            n1 /= 2;
            n2 /= 2;
        }
    }
    public String convert(int n) {
        if (n == 1) return "#";
        else return " ";
    }
}

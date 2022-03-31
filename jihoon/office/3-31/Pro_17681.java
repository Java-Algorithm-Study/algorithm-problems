// 1차 비밀지도
// https://programmers.co.kr/learn/courses/30/lessons/17681
class Pro_17681 {
    private int[][] arr;
    
    public void set(int n, int n1, int n2, int i) {
        while (n1 != 0 || n2 != 0) {
            if (n1 % 2 == 0 && n2 % 2 == 0) {
                arr[i][--n] = 0;
            } else {
                arr[i][--n] = 1;
            }
            n1 /= 2;
            n2 /= 2;
        }
    }
    
    public String convert(int n) {
        if (n == 1) {
            return "#";
        } else {
            return " ";
        }
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            set(n, arr1[i], arr2[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            var sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(convert(arr[i][j]));
            }
            ans[i] = sb.toString();
        }
        
        return ans;
    }
}

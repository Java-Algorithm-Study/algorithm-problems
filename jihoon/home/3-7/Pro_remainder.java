public class Pro_remainder {
    public static void main(String[] args) {
        int n = 12;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}

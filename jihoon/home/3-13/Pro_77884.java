public class Pro_77884 {
    public static int getNumberOfDiv(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) sum++;
        }
        return sum;
    }
    public static void main(String[] args) {
        int left = 24;
        int right = 27;
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (getNumberOfDiv(i) % 2 == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }
        System.out.println(sum);
    }
}

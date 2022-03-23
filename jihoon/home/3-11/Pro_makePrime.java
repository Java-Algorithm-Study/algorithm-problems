public class Pro_makePrime {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                for (int n = k + 1; n < nums.length; n++) {
                    int sum = nums[i] + nums[k] + nums[n];
                    if (isPrime(sum)) count++;
                }
            }
        }
        System.out.println(count);
    }
}

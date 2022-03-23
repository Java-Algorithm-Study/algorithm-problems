public class Pro_82612 {
    public static void main(String[] args) {
        int price = 3;
        int count = 4;
        int money = 20;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        long priceNeeded = (sum - money > 0) ? sum - money : 0;
        System.out.println(priceNeeded);
    }
}

import java.util.Arrays;

public class Pro_2016 {
    final static int[] daysOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    final static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    final static String firstDayOfYear = "FRI";

    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += daysOfMonth[i];
        }
        sum += b - 1;
        int daysFrom = sum % 7;
        int shift = Arrays.asList(days).indexOf(firstDayOfYear);

        String day = days[(daysFrom + shift) % 7];
        System.out.println(day);

    }
}

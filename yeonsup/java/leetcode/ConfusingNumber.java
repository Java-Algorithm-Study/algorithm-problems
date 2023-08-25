package yeonsup.java.leetcode;

import java.util.regex.Pattern;

public class ConfusingNumber {

    public boolean confusingNumber(int n) {
        boolean result = false;
        int[] arr = new int[10];
        int length = String.valueOf(n).length();
        int rotated = 0;
        int temp = n;

        if(Pattern.compile("[23457]").matcher(String.valueOf(n)).find()) return false;


        for (int i = 0; i < arr.length; i++) {
            arr[i] = i == 6 ? 9 : i == 9 ? 6 : i;
        }

        for (int i = length; i > 0; i--) {
            rotated *= 10;
            rotated += arr[temp % 10];
            temp /= 10;
        }

        if(n != rotated) result = true;
        System.out.println(rotated);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ConfusingNumber().confusingNumber(99));
        System.out.println(new ConfusingNumber().confusingNumber(111));
        System.out.println(new ConfusingNumber().confusingNumber(8000));
        System.out.println(new ConfusingNumber().confusingNumber(89));
        System.out.println(new ConfusingNumber().confusingNumber(25));
        System.out.println(new ConfusingNumber().confusingNumber(150));
    }
}

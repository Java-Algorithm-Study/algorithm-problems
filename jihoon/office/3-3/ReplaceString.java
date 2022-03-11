import java.util.Scanner;

public class ReplaceString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < numbers.length; i++) {
            if (line.contains(numbers[i])) {
                line = line.replaceAll(numbers[i], String.valueOf(i));
            }
        }
        System.out.println(line);
    }
}

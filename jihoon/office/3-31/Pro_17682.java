// 1차 다트게임
// https://programmers.co.kr/learn/courses/30/lessons/17682

import java.util.ArrayList;

public class Pro_17682 {
    
    public static int solution(String dartResult) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> options = new ArrayList<>();

        for (int i = 1; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            int index = i - 1;
            int area = convertIdentifier(ch);
            // 2D*2S#10S
            // S D T 중 하나일 때
            if (area > 0) {
                String number = "";
                while (Character.isDigit(dartResult.charAt(index))) {
                    number += dartResult.charAt(index);
                    index--;
                    if (index < 0)
                        break;
                }
                numbers.add((int) Math.pow(Integer.parseInt(number), area));
                char option = '1';
                if (i < dartResult.length() - 1) {
                    option =  dartResult.charAt(i + 1);
                }
                
                if (Character.isDigit(option)) {
                    options.add(1);
                } else if (option == '#') {
                    options.add(-1);
                } else if (option == '*') {
                    options.add(2);
                }
            }
        }
        System.out.println(numbers);
        return 0;
    }
    
    public static int convertIdentifier(char ch) {
        int number = -1;
        if (ch == 'S') {
            return 1;
        } else if (ch == 'D') {
            return 2;
        } else if (ch == 'T') {
            return 3;
        }
        return number;
    }
    
    public static void main(String[] args) {
        String dart = "1D*2S#10S";
        System.out.println(solution(dart));
    }
}

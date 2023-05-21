package language.java.Programmers;

public class Pro_17682 {

    public static int solution(String dartResult) {
        int answer = 0;
        int[] point = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) == '0') {
                continue;
            }

            if (Character.isDigit(dartResult.charAt(i))) {
                // 10일 때
                if (dartResult.charAt(i+1) == '0') {
                    point[idx] = 10;
                }
                // 1 ~ 9일 때
                else {
                    point[idx] = Integer.parseInt(String.valueOf(dartResult.charAt(i)));
                }
            }

            else {
                if (dartResult.charAt(i) == 'S') {
                    double tmp = Math.pow(point[idx], 1);
                    point[idx] = (int) tmp;
                }

                else if (dartResult.charAt(i) == 'D') {
                    double tmp = Math.pow(point[idx], 2);
                    point[idx] = (int) tmp;
                }

                else if (dartResult.charAt(i) == 'T') {
                    double tmp = Math.pow(point[idx], 3);
                    point[idx] = (int) tmp;
                }

                else if (dartResult.charAt(i) == '*') {
                    if (idx > 0) {
                        point[idx] *= 2;
                        point[idx-1] *= 2;
                    }
                    else {
                        point[idx] *= 2;
                    }
                }

                else if (dartResult.charAt(i) == '#') {
                    point[idx] *= -1;
                }

                if (i != dartResult.length() - 1) {
                    if (Character.isDigit(dartResult.charAt(i+1))) {
                        idx++;
                    }
                }
            }

        }

        for (int i : point) {
            answer += i;
        }

        return answer;
    }
}

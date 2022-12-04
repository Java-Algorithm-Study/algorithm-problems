/**
 * [17682] 다트게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 *
 * -아이디어
 * 1. 다트 게임이 총 3번 진행되니까 int[3] 배열을 만들어서 각 칸에 해당 판 점수를 넣는다.
 * 2. 각 점수, 보너스, 옵션에 따른 조건에 맞게 점수를 수정한다.
 * 3. 배열 원소의 합을 더해서 리턴한다.
 *
 * -시간 복잡도
 * 1. O(n)
 *
 * -자료 구조
 * 1. int[3] : 점수 담을 배열
 */

public class Pro17682_Again {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int idx = 0;

        String number = "";

        for (int i = 0; i < dartResult.length(); i++) {
            char now = dartResult.charAt(i);

            if ('0' <= now && now <= '9') {
                number += String.valueOf(now);
            }

            else if (now == 'S' || now == 'D' || now == 'T') {
                score[idx] = Integer.parseInt(number);

                if (now == 'S') {
                    score[idx] = (int) Math.pow(score[idx], 1);
                }
                else if (now == 'D') {
                    score[idx] = (int) Math.pow(score[idx], 2);
                }
                else if (now == 'T') {
                    score[idx] = (int) Math.pow(score[idx], 3);
                }
                idx++;
                number = "";
            }

            else {
                if (now == '*') {
                    if (idx >= 0) {
                        score[idx - 1] *= 2;
                        score[idx - 2] *= 2;
                    }
                    else {
                        score[idx - 1] *= 2;
                    }
                }

                else if (now == '#') {
                    score[idx - 1] *= -1;
                }
            }
        }


        for (int x : score) {
            answer += x;
        }

        return answer;
    }
}

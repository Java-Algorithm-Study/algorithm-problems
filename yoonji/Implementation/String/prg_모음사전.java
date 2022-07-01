package Implementation.String;

// 규칙을 찾아서 풀어야 하는 문제
// 5번째자리 바뀔 때 : +1씩
// 4번째자리 바뀔 때 : 1+ 5^1씩(문자 5개가 1자리 바뀜) = 6씩
// 3번째자리 바뀔 때 : 6+ 5^2씩(문자 5개가 2자리 바뀜) = 31씩
// 2번째자리 바뀔 때 : 31+ 5^3씩(문자 5개가 3자리 바뀜) = 156씩
// 1번째자리 바뀔 때 : 156+ 5^4씩(문자 5개가 4자리 바뀜) = 781씩
/* 아이디어
1. 자릿수에 따른 규칙을 위한 배열과 언급될 문자열 변수를 선언한다.
- 각 자릿수에 따라 바뀌는 규칙이 다르므로,
- 문자에 따라 순서가 다르므로 (A-E-I-O-U)
2. 단어의 길이만큼 반복문을 돌면서, word 문자에서 char 순서(0~4) * 자릿수에 따른 규칙 숫자를 더해서
3. 최종 값이 word의 순서
*/
public class prg_모음사전 {
    public int solution(String word) {
        int[] digitRule = {781, 156, 31, 6, 1}; // 첫번째 자리 바뀔 때 781
        String dict = "AEIOU";

        //AAAA(자릿수만큼) 의 수는 디폴트 (길이만큼)
        int answer = word.length(); // ex) AAAAE -> AAAAA에 대한 5로 세팅하고!

        // 각 숫자의 증가 규칙에 따라 ++
        for (int i=0; i<word.length(); i++) {
            answer += dict.indexOf(word.charAt(i)) * digitRule[i];
            System.out.println(answer);
        }
        return answer;
    }
}
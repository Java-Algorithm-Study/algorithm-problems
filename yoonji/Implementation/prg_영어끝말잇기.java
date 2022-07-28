package Implementation;

import java.util.HashSet;
import java.util.Set;
// - 문제 이해
// 1~n번 끝말잇기 (2<=n<=10)
// words 갯수 n~100 (단어 길이는 2~50)
// 이전에 등장한 단어 사용 x
// 단어 한글자 인정 x
// 먼저 탈락하는 사람의 번호와, 몇번째 차례인지? 배열로 return (탈락자 없으면 [0,0])
// 중복 단어 언급체크를 위해 set자료구조
// - 문제 해결
// 반복문을 돌며 차례 및 순서 계산
// 차례: 인덱스를 n으로 나눴을 때 몫. (만약 나눠떨어지지 않으면 몫+1이 차례)
// 번호: 인덱스를 n으로 나눈 나머지. (나머지가 0일 때는 순서값은 n)
// set 체크 & 앞뒤 연결되는지 체크

public class prg_영어끝말잇기 {
    public int[] solution (int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordSet = new HashSet<>();

        wordSet.add(words[0]);
        for (int i=1; i<words.length; i++) {
            char lastAlphabet = words[i-1].charAt(words[i-1].length()-1);
            if (wordSet.contains(words[i]) || lastAlphabet != words[i].charAt(0)) {
                // System.out.println(words[i]);
                int remainder = (i+1) % n;
                int quotient = (i+1) / n;
                if (remainder == 0) {
                    answer[0] = n;
                    answer[1] = quotient;
                } else {
                    answer[0] = remainder;
                    answer[1] = quotient +1;
                }
                break;
            }
            wordSet.add(words[i]);
        }
        return answer;
    }
}

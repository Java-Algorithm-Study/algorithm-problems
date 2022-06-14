import java.util.*;

public class prg_압축 {
    public static void main(String[] args) {
        prg_압축 t = new prg_압축();
        int[] answer = t.teamSolution("ABABABABABABABAB");
        for (int a: answer) {
            System.out.println(a);
        }
    }
    public int[] teamSolution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        // 1. dict A~Z 초기 세팅
        int dictIdx = 1;
        for (int i = 65; i < 65 + 26; i++) {
            dict.put(String.valueOf((char) i), dictIdx++);
        }
        String w = "";
        String temp = "";
        for (int i = 0; i < msg.length(); i++) {
            for (int j = i; j < msg.length(); j++) {
                w = msg.substring(i, j + 1);
                // 2. 포함된 단어가 아니라면,
                if (!dict.containsKey(w)) {
                    // 2-1. dict에 단어 추가
                    dict.put(w, dictIdx++);
                    // 2-2. 최신 단어 아닌 가장 큰 길이의 단어의 인덱스 추가
                    answer.add(dict.get(msg.substring(i, j)));
                    i = j - 1;  // for문에 의해 i++ 되므로 -1. (한 알파벳씩 추가되면서 새 단어가 되므로 i는 항상 한자리만 뒤로 돌아가면 된다)
                    temp = "";  // 최신 단어가 들어갔으므로 여태까지 거쳐온 포함된 단어는 reset시켜야한다. (for문 끝나고 마지막 단어 추가 여부를 위해)
                    break;
                // 3. 포함된 단어일 때는 기존에 포함된 단어("" or 단어)보다 긴 단어라면, 가장 긴 단어로 세팅.
                }else {
                    if (temp.length() < w.length()) temp = w;
                }
            }
        }
        // 마지막 알파벳에 대해서 새로운 단어 추가로 끝났을 경우, 무조건 해당 문자를 w로 방문하므로 temp가 ""인 경우는 없다.
        // 마지막 단어가 이미 추가된 단어인 경우, else문을 타고 i, j 모두 종료.
        //1번째 예시) 새 문자 KA'O'로 끝나서 O 출력
        //3번째 예시) 기존 문자 BABA로 끝나서 따로 출력X
        answer.add(dict.get(temp));
        return answer.stream().mapToInt(i->i).toArray();
    }
}
// my thought
// 무손실 압축 알고리즘. LZW 압축
// 1<=msg길이 <= 1000
//KAKAO
//K 이미 등록 (출력)-> 뒷자리 : KA 없음 -등록
// A 이미 등록 (출력)-> 뒷자리 : AK 없음 - 등록
// K 이미 등록 -> 뒷자리 : KA 이미 등록 (출력)-> 뒷자리 : KAO 없음 -등록
// O 이미 등록 (출력)
// 출력하는 색인은 마지막으로 이미 등록된 색인 출력
// A~Z로 26까지 찬 상태. 그 뒤 추가는 index+27 숫자.
// A~Z의 색인번호는 'A'-64 = 1
import java.util.HashSet;
import java.util.Set;

// 모든 수의 경우의 수를 구해서 소수인 경우, add => Brute-Force
public class prg_소수찾기 {
    static StringBuilder sb = new StringBuilder();         // StringBuilder가 지역 내에 있을 때 n개이상 생성이 되기 때문에 지역 내에 생성하기보다 전역으로 둬서 매번 비우는게 좋음.
    boolean[] visited;  // 방문 체크
    char[]  charArr;    // 반복문을 돌면서 문자 수를 완성시켜나갈 배열
    Set<Integer> returnSet = new HashSet<>();   // 중복제거 리턴 셋
    // 소수인지 확인
    public boolean isPrime(int p) {
        if (p == 1 || p == 0) return false;
        for (int i=2; i<p; i++) {   // p가 2인 경우,  2<2이므로 자동 i++
            if (p%i == 0) return false; // p가 어떤 수로 잘 나눠떨어지면 소수 x
        }
        return true;
    }

    // char[]을 length 길이만큼 잘라서 int형으로 변환(parseInt) 후 반환
    public int charArrToInt(char[] charArr, int length) {
        sb.setLength(0); // 전역에 StringBuilder를 생성하고 매번 사용 시에 sb를 초기화하는 것을 추천.
        for (int i=0; i<length; i++) {
            sb.append(charArr[i]);
        }
        return Integer.parseInt(new String(sb));
    }

    // dsf(깊이탐색)
    public void dfs(int level, int length, String numbers) {
        if (level == length) {  // length 자리수까지 모두 charArr에 들어왔으면 set에 추가
            int intNum = charArrToInt(charArr, length);
            if (isPrime(intNum)) returnSet.add(intNum);
        }
        else {  // level이 length만큼 들어오도록 length번 반복문 실행해서 자릿수를 매칭    <- 이걸 각 숫자(numbers.length)마다 실행 (아래 for문에 의해)
            for (int charIdx =0; charIdx < numbers.length(); charIdx++) {  // 1번째 반복문: arr[0] -> 이때 2번째자릿수 arr[1]를 정하는 반복문 => 모든 arr[0]에 해당하는 arr[1]을 반복문 돌면서 매칭
                if(!visited[charIdx]) {
                    System.out.println(charIdx);
                    visited[charIdx] = true;
                    charArr[level] = numbers.charAt(charIdx);   // dfs(0,1,numbers): charArr[0]=3으로 이미 visited[3]이 true니까 visited[3]에는 방문 x ex) 33, 00, 11, 44..
                    dfs(level+1, length, numbers);
                    visited[charIdx] = false;
                }
            }
        }
    }
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        charArr = new char[numbers.length()];

        for (int length=1; length<=numbers.length(); length++) { //  자릿수 길이이자 깊이 정도를 하나씩 늘리면서 매칭시킴
            dfs(0, length, numbers);
        }
        return returnSet.size();
    }
    public static void main(String[] args) {
        prg_소수찾기 k = new prg_소수찾기();
        int solution = k.solution("117");
        System.out.println(solution);
    }
}
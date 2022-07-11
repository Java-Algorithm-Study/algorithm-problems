package Implementation;

// - 까다로웠던 부분
// 해당 문제는 팰린드롬 조건과 상관없이 0<=s의 길이<=2500 으로 input된다는 점
// 길이를 잘라서 구하거나, 배열로 옮길 경우 효율성 탈락 (시간복잡도 고려)
public class prg_가장긴팰린드롬 {
    public int solution(String s)
    {
        int len = s.length();
        if (len <= 1) return len;

        for (int size=len; size >= 2; size--) {
            // 시작이 다를 수 있고
            for (int i=0; i<= len-size; i++) {
                // abacde
                int lastIdx = i+size-1;
                if (isPalindrome(s, i, lastIdx)) {
                    return size;
                }
            }
        }
        return 1;
    }
    private boolean isPalindrome(String s, int start, int last) {
        int len = last-start+1;
        int mid = start + len/2;
        for (int i=start; i< mid; i++, last--) {
            if (s.charAt(i) != s.charAt(last)){
                return false;
            }
        }
        return true;
    }
}
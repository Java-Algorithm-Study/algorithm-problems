public class prg_문자열압축 {
    /** 중복되는 문자를 숫자+"중복문자"로 압축하는데, 이때 가장 짧은 단어로 압축되는 단위를 골라야한다.
     * @return 가장 짧게 압축된 단어 길이
     */
    public static int solution(String s) {
        if (s.length() == 1) return 1;
        int min = Integer.MAX_VALUE;
        int length = s.length();

        for (int size = 1; size <= length / 2; size++) {
            int duplicateCount = 1;
            int strLength = 0;
            int remainingDigits = length % size;
            int lastCursor = length - remainingDigits - 2 * size;
            for (int i = 0; i <= lastCursor; i += size) {
                String first = s.substring(i, i + size);
                String second = s.substring(i + size, i + 2 * size);
                if (first.equals(second)) {
                    duplicateCount++;
                    if (i == lastCursor) strLength += second.length() + String.valueOf(duplicateCount).length();
                }
                else {
                    if (i == lastCursor) strLength += second.length();
                    if (duplicateCount > 1) strLength += String.valueOf(duplicateCount).length() + first.length();
                    else strLength += first.length();
                    duplicateCount = 1;
                }
            }
            strLength += remainingDigits;
            min = Math.min(strLength, min);
        }
        return min;
    }
}

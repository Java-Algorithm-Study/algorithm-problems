public class Pro_60057 {
    public static int solution(String s) {
        if (s.length() == 1) return 1;
        int min = Integer.MAX_VALUE;
        int length = s.length();

        for (int size = 1; size <= length / 2; size++) {
            int count = 1;
            int sLength = 0;
            int mod = length % size;
            int lastCursor = length - mod - 2 * size;

            for (int i = 0; i <= lastCursor; i += size) {
                String first = s.substring(i, i + size);
                String second = s.substring(i + size, i + 2 * size);

                // first 랑 second 같을 때
                if (first.equals(second)) {
                    count++;
                    if (i == lastCursor) sLength += second.length() + String.valueOf(count).length();
                }

                //first 랑 second 다를 때
                else {
                    if (i == lastCursor) sLength += second.length();
                    if (count > 1) {
                        sLength += String.valueOf(count).length() + first.length();
                    } else {
                        sLength += first.length();
                    }
                    count = 1;
                }
            }
            sLength += mod;
            min = Math.min(sLength, min);
        }
        return min;
    }
}

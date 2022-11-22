// again

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += Math.min(Math.abs(name.charAt(i) - 'A'), Math.abs(name.charAt(i) - 'A' - 26));
            }

            int idxA = i+1;
            while (idxA < name.length() && name.charAt(idxA) == 'A') {
                idxA++;
            }
            
            len = Math.min(len, i + i + name.length() - idxA);
            len = Math.min(len, name.length() - idxA + name.length() - idxA + i);
        }

        return answer + len;
    }
}

public class Pro_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalCnt = brown + yellow;
        for (int i = 3; i < totalCnt; i++) {
            if(totalCnt % i == 0) {
                int b = totalCnt / i;
                int y = i;
                int x = (b * 2) + (y * 2) - 4;
                if(x == brown) {
                    answer[0] = b;
                    answer[1] = y;
                    break;
                }
            }
        }
        return answer;
    }
}

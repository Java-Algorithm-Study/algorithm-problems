public class Pro_77884 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int possible = 0;
        int n = 7;
        for (int lotto : lottos) {
            if (lotto == 0) possible++;
            for (int win_num : win_nums) {
                if (lotto == win_num) count++;
            }

        }
        int[] answer = new int[2];
        answer[0] = (count + possible == 0) ? 6 : n - (count + possible);
        answer[1] = count == 0 ? 6 : n - count;
        return answer;
    }
    public static void main(String[] args) {

    }
}

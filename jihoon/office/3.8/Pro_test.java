class Pro_test {
    public int[] solution(int[] answers) {

        int[][] person = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (person[0][i % person[0].length] == answers[i]) {
                count[0]++;
            }
            if (person[1][i % person[1].length] == answers[i]) {
                count[1]++;
            }
            if (person[2][i % person[2].length] == answers[i]) {
                count[2]++;
            }
        }

        String str = "";

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= max) {
                max = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                str += i + 1;
            }
        }
        int[] answer = new int[str.length()];
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(ch[i]));
        }

        return answer;
    }
}
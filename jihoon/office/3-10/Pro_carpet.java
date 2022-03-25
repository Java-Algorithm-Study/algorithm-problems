class Pro_carpet {
    public int[] solution(int brown, int yellow) {
        int a = brown / 2 + 2;
        int b = yellow + brown;

        double alpha = (a + Math.sqrt(a * a - 4 * b)) / 2;
        double beta = a - alpha;

        int[] answer = {(int) alpha, (int) beta};

        return answer;
    }
}
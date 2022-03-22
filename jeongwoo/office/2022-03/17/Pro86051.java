class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] checked = new boolean[10];
        
        for (int i = 0; i < numbers.length; i++) {
            checked[numbers[i]] = true;
        }
        
        for (int i = 0; i < 10; i++) {
            if (!checked[i])
                answer += i;
        }
        return answer;
    }
}

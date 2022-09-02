public class Prg_최댓값과최솟값 {
    public String solution(String s) {
        String[] numArr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : numArr) {
            int number = Integer.parseInt(str);
            max = Math.max(number, max);
            min = Math.min(number, min);
        }
        return min + " " + max;
    }
}
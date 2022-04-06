import java.util.ArrayList;
import java.util.List;

public class prg_3진법뒤집기 {
    public static void main(String[] args) {
        prg_3진법뒤집기 k = new prg_3진법뒤집기();
        System.out.println(k.solution(125));
    }
    public int solution(int n) {
        int answer = 0;
        // n -> 3진법
        List<Integer> arr = new ArrayList<>();
        while (n != 0) {
            arr.add(n%3);
            n /= 3;
        }
        // 3진법 -> 10진법 : n진 -> 10진 변환 시, Math.pow(n, i)
        for (int i=0; i< arr.size(); i++) {
            answer += arr.get(i) * Math.pow(3, arr.size() - i - 1);
        }
        return answer;
    }
}
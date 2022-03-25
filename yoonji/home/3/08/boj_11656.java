import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 접미사 배열
// 문자열이 주어지면
// 모든 접미사를 구하고, 이를 "사전순"으로 정렬
public class boj_11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        List<String> words = new ArrayList<>();
        // 1. 접미사 구하기
        for (int i=0; i<word.length(); i++) {
            words.add(word.substring(i, word.length()));
        }
        // 2. 사전순 정렬 및 출력
        words.stream().sorted().forEach(System.out::println);
    }
}
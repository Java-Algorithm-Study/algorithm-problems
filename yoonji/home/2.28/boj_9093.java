import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9093 {
    static StringBuilder printSB = new StringBuilder();

    private static void solving() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        String[] sentence;
        for (int i = 0; i < lines; i++) {
            sentence = br.readLine().split(" ");
            for(int j=0; j<sentence.length; j++) {
                reverseWord(sentence[j]);
            }
            System.out.println(printSB.toString());
            printSB.setLength(0);    // 초기화
        }
    }
    private static void reverseWord(String word) {
        printSB.append(new StringBuilder(word).reverse());
        printSB.append(" ");
    }

    public static void main(String[] args) throws IOException {
        solving();
    }
}

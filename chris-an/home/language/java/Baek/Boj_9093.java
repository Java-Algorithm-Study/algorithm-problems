package language.java.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 단어뒤집기 9093번
public class Boj_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String [] sentence = new String[cnt];
        for(int i = 0; i < cnt; i++) {
            sentence[i] = br.readLine();
        }

        for (int i = 0; i < cnt; i++) {
            String word = "";
            String [] words = sentence[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                for (int k = words[j].length(); k > 0 ; k--) {
                    word += words[j].charAt(k-1);
                }
                word += " ";
            }
            System.out.println(word);
        }
    }
}

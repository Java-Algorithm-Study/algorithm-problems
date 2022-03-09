import java.io.*;
import java.util.*;

public class Boj_11656 {


    /*
        접미사 배열 11656 번

        문자열 정렬,
        정렬의 종류는 여러가지 종류가 있다.
        여러 정렬을 비교하면서 어떤 정렬이 나은지 비교해보고 사용 익숙해지기

     */

    /*
        1. 자바에 내장된 API를 사용하지 않고 구현.
        2. Arrays.sort 사용.
        3. Comparator API 사용
        4. Collections.sort 사용

        Arrays.sort()와 Collections.sort()의 차이
        - Arrays.sort()는 Dual-Pivot Quicksort를 사용합니다.
        - Collections.sort()는 merge sort와 insert sort를 합친 timsort를 사용합니다.
        - Quick sort는 배열에서 좋은 성능을 보이지만 stable하지 않아서 stable이 필요한 Object에는 Collections.sort()가 많이 쓰입니다.

        https://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not
     */


    public static int compare1(String word1, String word2) {

        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return word1.charAt(i) - word2.charAt(i);
            }
        }
        if (word1.length() != word2.length()) return word1.length() - word2.length();
        return 0;
    }

    public static String [] stringSort (String [] words) {

        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (compare1(words[i], words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        //List<String> array = new ArrayList<>();
        String [] array = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            //array.add(str.substring(i));
            array[i] = str.substring(i) + " ";
        }

        //String [] result = stringSort(array);
        //Collections.sort(array);
        //array.sort(Comparator.naturalOrder());
        Arrays.sort(array);

//        for (int i = 0; i < result.length; i++) {
//            bw.write(result[i] + " ");
//        }
//        for (int i = 0; i < array.size(); i++) {
//            bw.write(array.get(i) + " ");
//        }
        for (int i = 0; i < array.length; i++) {
            bw.write(array[i] + " ");
        }


        bw.flush();
        bw.close();
        br.close();

    }
}

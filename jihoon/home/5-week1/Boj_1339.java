import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1339 {
    private static String[] words;
    private static int numberOfAlphabets;
    private static ArrayList<Character> alphabets;
    private static int[] temp;
    private static boolean[] visited;
    private static ArrayList<Integer> numbers = new ArrayList<>();
    private static int maxSum = 0;
    
    public static void dfs(int depth) {
        if (depth == numberOfAlphabets) {
            calcuateSum(temp);
            return;
        }
        
        for (int i = 0; i < numberOfAlphabets; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[depth] = numbers.get(i);
            dfs(depth + 1);
            visited[i] = false;
        }
    }
    
    public static void calcuateSum(int[] nums) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabets.size(); i++) {
            map.put(alphabets.get(i), nums[i]);
        }
        int sum = 0;
        for (String word : words) {
            int localSum = 0;
            for (int i = 0; i < word.length(); i++) {
                // 10의 거듭제곱을 하는 부분
                // Math.pow(10, word.length() - i - 1) 이렇게 하면 시간 초과가 난다
                int multiplier = 1;
                for (int j = 0; j < word.length() - i - 1; j++) {
                    multiplier *= 10;
                }
                localSum += multiplier * map.get(word.charAt(i));
            }
            sum += localSum;
        }
        if (sum > maxSum) maxSum = sum;
    }
    
    public static void countAlphabets(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }
        makeAlphabets(set);
        numberOfAlphabets = set.size();
    }
    
    public static void makeAlphabets(Set<Character> set) {
        alphabets = new ArrayList<>(set);
    }
    
    public static void makeNumbers(int n) {
        int number = 9;
        while (numbers.size() != n) {
            numbers.add(number);
            number--;
        }
    }
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        // 주어진 총 알파벳 갯수를 센다
        countAlphabets(words);
        // 알파벳 갯수만큼 9부터 수를 만든다
        makeNumbers(numberOfAlphabets);
        temp = new int[numberOfAlphabets];
        visited = new boolean[numberOfAlphabets];
        
        dfs(0);
        System.out.println(maxSum);
    }
}


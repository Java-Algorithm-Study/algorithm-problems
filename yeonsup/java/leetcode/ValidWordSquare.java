package yeonsup.java.leetcode;

import java.util.List;

public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        int size = Math.max(words.size(), words.get(0).length());

        for(int j = 0;j<words.size();j++)
            size = Math.max(size,words.get(j).length());

        char[][] chars = new char[size][size];

        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                chars[i][j] = words.get(i).charAt(j);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if(chars[i][j] != chars[j][i]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new ValidWordSquare().validWordSquare(List.of("abcd","bnrt","crmy","dtye")));
//        System.out.println(new ValidWordSquare().validWordSquare(List.of("ball","area","read","lady")));
//        System.out.println(new ValidWordSquare().validWordSquare(List.of("ball","asee","let","lep")));
        System.out.println(new ValidWordSquare().validWordSquare(List.of("abc", "b")));
    }
}

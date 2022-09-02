
public class Prg_JadenCase문자열만들기 {
    public String convertWord(String tempString) {
        String checkChar = ("" + tempString.charAt(0)).toUpperCase();
        tempString = tempString.substring(1, tempString.length()).toLowerCase();
        checkChar += tempString;

        return checkChar;
    }

    public String solution(String s) {
        String answer = "";
        char target = s.charAt(0);
        String tempString = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                tempString += ("" + c);
            }else { // 공백
                if (!tempString.isEmpty()) {
                    answer += convertWord(tempString) + " ";
                    tempString = "";
                } else {
                    answer += ("" + c); // 공백은 더해주기
                }
            }
        }

        if(answer.length() == s.length()) {
            return answer;
        }else {
            return answer += convertWord(tempString);
        }
    }
}
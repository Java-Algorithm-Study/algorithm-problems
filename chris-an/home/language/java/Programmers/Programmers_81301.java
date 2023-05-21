package language.java.Programmers;

public class Programmers_81301 {

    public int solution(String s) {

    String [] initArray = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    String [] arArray = {"1","2","3","4","5","6","7","8","9"};
        int answer;
        for(int i = 0; i < initArray.length; i++) {
            if(s.contains(initArray[i])) {
                s = s.replace(initArray[i], arArray[i]);

            }
        }
        answer = Integer.parseInt(s);

        return answer;
    }
}
package language.java.Programmers;

import java.util.*;

public class Pro_수식최대화 {
    public long calculatePriceMoney(long num1, long num2, char operator) {
        long result = 0;

        switch(operator) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
        }
        return result;
    }

    public long findMaxPriceMoney(String opType, ArrayList<Long> number, ArrayList<Character> operator) {
        long result = 0;

        for (int j = 0; j < opType.length(); j++) {
            for (int k = 0; k < operator.size(); k++) {
                if (opType.charAt(j) == operator.get(k)) {
                    long num1 = number.get(k);
                    long num2 = number.remove(k+1);
                    char op = operator.remove(k);
                    long calculatedNumber = calculatePriceMoney(num1, num2, op);
                    number.set(k, calculatedNumber);
                    k--;
                }
            }
        }
        return Math.abs(number.get(0));
    }

    public long solution(String expression) {
        ArrayList<Character> operator = new ArrayList<>();
        ArrayList<Long> number = new ArrayList<>();
        String[] operatorType = {
                "+-*",
                "+*-",
                "-+*",
                "-*+",
                "*+-",
                "*-*"
        };
        long answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if(Character.isDigit(expression.charAt(i))) {
                sb.append(expression.charAt(i));
            }else {
                number.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operator.add(expression.charAt(i));
            }
        }
        number.add(Long.parseLong(sb.toString()));
        for (int i = 0; i < operatorType.length; i++) {
            ArrayList<Long> tmpNumber = new ArrayList<>();
            tmpNumber.addAll(number);
            ArrayList<Character> tmpOperator = new ArrayList<>();
            tmpOperator.addAll(operator);
            long target = findMaxPriceMoney(operatorType[i], tmpNumber, tmpOperator);
            answer = Math.max(answer, target);
        }

        return answer;
    }
}

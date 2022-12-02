import java.io.IOException;

public class Pro_17687 {

    public static void main(String[] args) throws IOException {

        int n= 2, t=4, m=2, p=1;

        StringBuilder answer = new StringBuilder();
        int number = 0;
        int order=1;
        while(true){
            String s = convert(n, number);


            for(char c: s.toCharArray()){
                if(order==p) answer.append(c);
                order++;
                if(order>m) order=1;
                if(answer.length() >= t) break;
            }

            number++;
            if(answer.length() >= t) break;
        }

        System.out.println(answer.toString());

    }

    public static String convert(int n, int number){
        StringBuilder sb = new StringBuilder();

        while (true){
            int r = number%n;

            if(r==10) sb.append("A");
            else if(r==11) sb.append("B");
            else if(r==12) sb.append("C");
            else if(r==13) sb.append("D");
            else if(r==14) sb.append("E");
            else if(r==15) sb.append("F");
            else sb.append(r);

            number/=n;
            if(number==0) break;
        }

        return sb.reverse().toString();
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Pro_17686 {
    
    public static class File {
        private String head;
        private String number;
        private String tail;
    
        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public String toString() {
            return head + number + tail;
        }
    }
    
    public static String[] solution(String[] files) {
        String[] answer = {};
        File[] file = new File[files.length];
        
        for (int i = 0; i < files.length; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int index = 0;
            while (!Character.isDigit(files[i].charAt(index))) {
                head.append(files[i].charAt(index++));
            }

            while (Character.isDigit(files[i].charAt(index))) {
                number.append(files[i].charAt(index++));
                if (index >= files[i].length()) break;
            }
            File f = new File(String.valueOf(head), String.valueOf(number), files[i].substring(index));
            file[i] = f;
        }
    
        Arrays.sort(file, (f1, f2) -> {
            int hello  = f1.head.toLowerCase().compareTo(f2.head.toLowerCase());
            if (hello == 0) {
                return Integer.parseInt(String.valueOf(f1.number)) - Integer.parseInt(String.valueOf(f2.number));
            } else {
                return hello;
            }
        });
        
        answer = new String[file.length];
        for (int i = 0; i < file.length; i++) {
            answer[i] = file[i].toString();
        }
        return answer;
    }
    
    public static void main(String[] args) {
        String[] files = {"O00321", "O49qcGPHuRLR5FEfoO00321"};
        System.out.println(Arrays.toString(solution(files)));
    }
}

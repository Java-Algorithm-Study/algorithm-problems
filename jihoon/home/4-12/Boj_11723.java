import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Boj_11723 {
    private static Set<Integer> set = new HashSet<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<Integer> list = new ArrayList<>();
    
    public static void make20() {
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }
    }

    public static void excuteLine(String order, int n) throws IOException{
        if ("add".equals(order)) {
            set.add(n);
        } else if ("remove".equals(order)) {
            set.remove(n);
        } else if ("check".equals(order)) {
            if (set.contains(n)) {
                bw.write(1 + "\n");
            } else {
                bw.write(0 + "\n");
            }
        } else if ("toggle".equals(order)) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        } else if ("all".equals(order)) {
            set.clear();
            set.addAll(list);
        } else if ("empty".equals(order)) {
            set.clear();
        }
    }
    
    public static void main(String[] args) throws IOException {
        var bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        make20();
        for (int i = 0; i < N; i++) {
            String[] line = bf.readLine().split(" ");
            String order = line[0];
            int n = 0;
            if (line.length > 1) {
                n = Integer.parseInt(line[1]);
            }
            excuteLine(order, n);
        }
        bf.close();
        bw.flush();
        bw.close();
    }
}

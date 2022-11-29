import java.util.*;

/**
 * [17686] 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 *
 * -아이디어
 * 1. 정렬 해결: PriorityQueue 정렬을 커스텀해 사용한다.
 */

public class Pro_17686 {
    public static void main(String[] args){

        String[] files=  {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};


        PriorityQueue<Main.Node> pq = new PriorityQueue<Main.Node>();
        for(int i=0; i< files.length; i++){
            pq.offer(new Main.Node(files[i],i));
        }

        String[] answer = new String[pq.size()];
        for(int i=0; i< answer.length; i++){
            Main.Node poll = pq.poll();
            answer[i] = poll.head+poll.number+poll.tail;
        }

        for(int i=0; i< answer.length; i++){
            System.out.println(answer[i]);
        }

    }
    static class Node implements Comparable<Main.Node>{
        String head;
        String number;
        String tail;
        int order;

        public Node (String s, int order){
            this.order=order;

            int number_index=0;
            for(int i=0; i<s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    number_index = i;
                    break;
                }
            }
            head = s.substring(0, number_index);

            int tail_index = number_index;
            for(int i=number_index; i<s.length(); i++){
                if(!Character.isDigit(s.charAt(i))) {
                    tail_index = i;
                    break;
                }
                if(i==s.length()-1) tail_index=s.length();
            }
            number = s.substring(number_index, tail_index);

            if(tail_index == s.length()) tail = "";
            else tail = s.substring(tail_index);
        }

        @Override
        public int compareTo(Main.Node o){
            if(head.toUpperCase().compareTo(o.head.toUpperCase()) == 0){
                if(Integer.parseInt(number) - Integer.parseInt(o.number) ==0){
                    return order - o.order;
                }
                return Integer.parseInt(number) - Integer.parseInt(o.number);
            }
            return head.toUpperCase().compareTo(o.head.toUpperCase());
        }
    }
}

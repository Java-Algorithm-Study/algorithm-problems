package kakao.a2019;


import java.util.*;

/**
 * [42893] 매칭 점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42893
 *
 * -아이디어
 *  1. 문자열 문제다. 점수를 순서대로 정확히 구한다.
 *
 */

public class Pro_42893 {
    public static void main(String[] args) {
        System.out.println(solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
    }

    public static int solution(String word, String[] pages) {

        Page[] result = new Page[pages.length];
        //구해야 하는 점수들
        //1. 기본점수
        //2. 외부 링크 수
        //3. 링크점수(타 웹에서 자기웹으로 오는경우에 [타 웹들의 기본점수/외부링크수] 총합)
        //4. 매칭점수(기본점수+링크점수)

        ArrayList<ArrayList<String>> list = new ArrayList<>();
        for(int i=0; i<pages.length; i++) list.add(new ArrayList<String>());


        word = word.toUpperCase(); //대문자 통일
        for(int i=0; i<pages.length; i++){
            String s = pages[i];
            s= s.replace("\n", " ");

            //자신 주소 구하기
            int url_start = s.indexOf("<meta property=\"og:url\" content=");
            int url_end = s.indexOf("/>", url_start+1);
            String content = s.substring(url_start, url_end).replace("<meta property=\"og:url\" content=", "");

            //기본점수 구하기
            int basic_score = 0;
            int start = s.indexOf("<body>");
            int end = s.indexOf("</body>");
            String bodys = s.substring(start+ "<body>".length(), end);
            String text = bodys.toUpperCase();

            int cur = 0;
            while(true){
                text = text.substring(cur);
                if(text.indexOf(word)>=0){
                    cur = text.indexOf(word);
                    if(cur-1>=0 ){
                        if(Character.isAlphabetic(text.charAt(cur-1))){
                            cur+=word.length()+1;
                            continue;
                        }
                    }
                    if(cur+word.length()<text.length()){
                        if(Character.isAlphabetic(text.charAt(cur+word.length()))){
                            cur+=word.length()+1;
                            continue;
                        }
                    }
                    cur+=word.length()+1;
                    basic_score++;
                }
                else break;
            }



            //외부 링크 구하기
            int outLink_score=0;
            String[] tokens = bodys.split(" ");
            cur = 0;
            while(true){
                bodys = bodys.substring(cur);
                if(bodys.indexOf("<a href") >= 0 ){
                    cur = bodys.indexOf("<a href") + 8;
                    String tmp[] = bodys.substring(cur).split(">");
                    list.get(i).add(tmp[0]); //자신이 가지고 있는 외부링크들 데이터화 (링크 점수 구할 때 쓰임)
                    outLink_score++;
                }
                else break;
            }

            result[i] = new Page(basic_score, outLink_score, content);
        }


        //링크점수 구하기
        for(int i=0; i<pages.length; i++){
            int size = list.get(i).size();

            for(int j=0; j<size; j++){
                String s = list.get(i).get(j);

                for(int k=0; k<result.length; k++){
                    if(result[k].content.equals(s)){
                        result[k].link += ((double)result[i].basic/result[i].outLink);
                    }
                }
            }
        }

        //매치점수 구하기
        int answer = 0;
        double max = 0;
        for(int i=0; i<pages.length; i++){
            double match = result[i].basic + result[i].link;
            if(max<match){
                answer = i;
                max = match;
            }
        }
        return answer;
    }

    static class Page{
        int basic;
        int outLink;
        double link;
        double match;
        String content; // "https://a.com"
        public Page(int a, int b, String c){
            basic=a; outLink=b; content=c; link=0; match=0;
        }
    }
}

/*
테스트 1 〉	통과 (4.25ms, 80.6MB)
테스트 2 〉	통과 (2.87ms, 83.4MB)
테스트 3 〉	통과 (4.24ms, 88.9MB)
테스트 4 〉	통과 (4.59ms, 72MB)
테스트 5 〉	통과 (3.89ms, 77.3MB)
테스트 6 〉	통과 (4.03ms, 79.4MB)
테스트 7 〉	통과 (4.24ms, 76.6MB)
테스트 8 〉	통과 (3.25ms, 77.5MB)
테스트 9 〉	통과 (4.23ms, 80.6MB)
테스트 10 〉	통과 (4.37ms, 79.2MB)
테스트 11 〉	통과 (1.87ms, 79MB)
테스트 12 〉	통과 (2.08ms, 76.6MB)
테스트 13 〉	통과 (2.66ms, 83.6MB)
테스트 14 〉	통과 (2.77ms, 74.2MB)
테스트 15 〉	통과 (2.20ms, 85.2MB)
테스트 16 〉	통과 (0.73ms, 77.8MB)
테스트 17 〉	통과 (1.83ms, 79MB)
테스트 18 〉	통과 (0.60ms, 81.1MB)
테스트 19 〉	통과 (1.17ms, 74.6MB)
테스트 20 〉	통과 (5.16ms, 78.3MB)
 */
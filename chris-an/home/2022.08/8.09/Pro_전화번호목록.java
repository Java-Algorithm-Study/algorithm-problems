public class Pro_튜플 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i-1])) {
                return false;
            }
        }
        return true;
    }
}
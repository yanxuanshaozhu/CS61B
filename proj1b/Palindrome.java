public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length() <= 1) {
            return true;
        }
//        StringBuilder builder = new StringBuilder(word);
//        String reverse = builder.reverse().toString();
//        return word.equals(reverse);
        Deque<Character> deque = wordToDeque(word);
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.removeLast());
        }
        return builder.toString().equals(word);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        if (word.length() <= 1) {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        String reverse = builder.reverse().toString();
        for (int i = 0; i < word.length(); i++) {
            char origin = word.charAt(i);
            char comparison = reverse.charAt(i);
            if (!cc.equalChars(origin, comparison)) {
                return false;
            }
        }
        return true;
    }
}

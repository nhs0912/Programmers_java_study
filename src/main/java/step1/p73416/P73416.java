package step1.p73416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game {
    private Users users;
    private Words words;
    private int[] result = new int[2];

    public Game(Users users, Words words) {
        this.users = users;
        this.words = words;

    }

    public int[] start() {

        int wordSize = words.wordListSize();

        for (int i = 0; i < wordSize; i++) {
            String word = words.wordList().get(i);
            User user = users.user(i % users.userCount());

            if (checkWholeDuplicateWord(users, word) || !words.checkLinkWords(i)) {
                result[0] = user.number;
                result[1] = user.wordList().size() + 1;
                return result;
            }
            user.saveWord(word);
        }

        return result;
    }

    private boolean checkWholeDuplicateWord(Users users, String word) {
        for (User user : users.userList()) {
            if (user.checkDuplicateWord(word)) {
                return true;
            }
        }
        return false;
    }
}

class Words {
    private List<String> wordList;
    private static final int FIRST_NUMBER = 0;

    public Words(List<String> wordList) {
        this.wordList = wordList;
    }

    public boolean checkLinkWords(int currentIndex) {

        if (currentIndex == 0) {
            return true;
        }

        int preIndex = currentIndex - 1;
        String preWord = wordList.get(preIndex);
        String currentWord = wordList.get(currentIndex);

        return checkSameFirstAndLast(preWord, currentWord);
    }

    public boolean checkSameFirstAndLast(String firstWord, String secondWord) {
        int lastCharIndexOfFirstWord = firstWord.length() - 1;
        char lastCharOfFirstWord = firstWord.charAt(lastCharIndexOfFirstWord);
        char firstCharOfSecondWord = secondWord.charAt(FIRST_NUMBER);
        return lastCharOfFirstWord == firstCharOfSecondWord;
    }

    public List<String> wordList() {
        return this.wordList;
    }

    public int wordListSize() {
        return this.wordList.size();
    }
}

class User {

    int number;
    private List<String> wordList = new ArrayList<>();

    public User(int number) {
        this.number = number;
    }

    public void saveWord(String word) {

        wordList.add(word);
    }

    public int number() {
        return this.number;
    }

    public List wordList() {
        return this.wordList;
    }

    public boolean checkDuplicateWord(String word) {
        return wordList.contains(word);
    }

}


class Users {

    private List<User> userList;

    public Users(int n) {
        List<User> madeUserList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            madeUserList.add(new User(i + 1));
        }
        this.userList = madeUserList;
    }

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> userList() {
        return this.userList;
    }

    public int userCount() {
        return this.userList.size();
    }

    public User user(int number) {
        return this.userList.get(number);
    }

}

class Solution {
    public int[] solution(int n, String[] words) {
        Users users = new Users(n);
        Words inputWords = new Words(Arrays.asList(words));
        Game game = new Game(users, inputWords);

        return game.start();
    }
}

public class P73416 {


}

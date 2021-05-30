package step1.p73416;

import java.util.ArrayList;
import java.util.List;

class Game {

    public Game(Users users,List<String> wordList) {


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

    public List wordList() {
        return this.wordList;
    }

}


class Users {

    private List<User> userList;

    public Users(List<User> userList) {
        this.userList = userList;
    }

    public List<User> userList() {
        return this.userList;
    }

}



public class P73416 {


}

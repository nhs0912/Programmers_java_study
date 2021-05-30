package step1.p73416;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class P73416Test {


    List<String> wordList1;
    List<String> wordList2;
    List<String> wordList3;

    Users users;


    @BeforeEach
    void setUp() {
        wordList1 = Arrays.asList("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank");
        wordList2 = Arrays.asList("hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive");
        wordList3 = Arrays.asList("hello", "one", "even", "never", "now", "world", "draw");

        users = new Users(Arrays.asList(new User(1), new User(2), new User(3)));

    }

    @Test
    @DisplayName("각 사람에게 단어 저장하는 테스트")
    void saveWordTest() {
        User user = new User(1);
        user.saveWord("tank");

        assertThat(user.wordList().contains("tank")).isTrue();
    }

    @Test
    @DisplayName("끝말잇기가 제대로 되었는지 확인하는 테스트")
    void gameTest() {
        Game game = new Game(users,wordList1);
    }


}

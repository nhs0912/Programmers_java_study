package step1.p73416;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class P73416Test {


    List<String> wordList1;
    List<String> wordList2;
    List<String> wordList3;
    List<String> wordList4;
    Users users;


    @BeforeEach
    void setUp() {
        wordList1 = Arrays.asList("tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank");
        wordList2 = Arrays.asList("hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive");
        wordList3 = Arrays.asList("hello", "one", "even", "never", "now", "world", "draw");
        wordList4 = Arrays.asList("tank", "kick", "string");
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

        Words words4 = new Words(wordList4);

        assertAll(
                () -> assertThat(words4.checkLinkWords(2)).isFalse(),
                () -> assertThat(words4.checkLinkWords(1)).isTrue()
        );


    }

    @Test
    @DisplayName("단어 중복이 있는지 검사")
    void checkDuplicateWordTest() {

        Game game = new Game(new Users(3), new Words(wordList1));
        Game game2 = new Game(new Users(5), new Words(wordList2));
        Game game3 = new Game(new Users(2), new Words(wordList3));

        assertAll(
                ()-> assertThat(game.start()).containsExactly(3,3),
                ()-> assertThat(game2.start()).containsExactly(0,0),
                ()-> assertThat(game3.start()).containsExactly(1,3)
        );


    }

}

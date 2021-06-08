package step1.p73419;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P73419Test {

    private String[] inputWords;
    private int n;

    @BeforeEach
    void setUp() {
        inputWords = new String[]{"sun", "bed", "car"};

        n = 1;
    }

    @Test
    @DisplayName("기준 글자로 정렬이 잘 되는지 확인")
    void sortTest() {
//        inputWords = new String[]{"abce", "abcd", "cdx"};

        List<Word> wordList = new ArrayList<>();
        Arrays.stream(inputWords)
                .forEach(str -> wordList.add(new Word(str, n)));

        Words words = new Words(wordList);
        words.sort();
        String[] output = words.convertToStringArr();
        Assertions.assertThat(output).containsExactly("car","bed","sun");
//        Assertions.assertThat(output).containsExactly("abcd", "abce", "cdx");
    }

}

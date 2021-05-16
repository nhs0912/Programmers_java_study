package step1.solution3;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1_3Test {
    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    private Solution1_3 s = new Solution1_3();

    @Test
    @DisplayName("mainTest")
    void mainTest(){
        int[] answers = new int[]{1, 2, 3, 4, 5};
        assertThat(s.solution(answers)).containsExactly(1);

        int[] answers2 = new int[]{1, 3, 2, 4, 2};
        assertThat(s.solution(answers2)).containsExactly(1,2,3);
    }

    @Test
    @DisplayName("숫자만큼 정답을 loop도는지 확인")
    void loopTest() {

        assertAll(
                () -> assertThat(s.loopAnswer(3, firstHumanAnswer)).containsExactly(1, 2, 3),
                () -> assertThat(s.loopAnswer(3, secondHumanAnswer)).containsExactly(2, 1, 2),
                () -> assertThat(s.loopAnswer(3, thirdHumanAnswer)).containsExactly(3, 3, 1)
        );
    }

    @Test
    @DisplayName("정답과 비교하는 test")
    void compareAnswerTest() {

        int[] answers = new int[]{1, 2, 3, 4, 5};
        int answersSize = answers.length;
        List<Integer> firstHumanAnswerList = s.loopAnswer(answersSize, firstHumanAnswer);
        List<Integer> secondHumanAnswerList = s.loopAnswer(answersSize, secondHumanAnswer);
        List<Integer> thirdHumanAnswerList = s.loopAnswer(answersSize, thirdHumanAnswer);

        assertAll(
                () -> assertThat(s.correctedAnswerCount(answers, firstHumanAnswerList)).isEqualTo(5),
                () -> assertThat(s.correctedAnswerCount(answers, secondHumanAnswerList)).isEqualTo(0),
                () -> assertThat(s.correctedAnswerCount(answers, thirdHumanAnswerList)).isEqualTo(0)
        );
    }


}

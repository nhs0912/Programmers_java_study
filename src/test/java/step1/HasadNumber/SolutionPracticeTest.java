package step1.HasadNumber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.HasadNumber.SolutionPractice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class SolutionPracticeTest {

    SolutionPractice s;

    @BeforeEach
    void SetUp() {
        s = new SolutionPractice();
    }

    @Test
    @DisplayName("하샤드 수인지 판별하는 TEST")
    void numberTest() {


        assertAll(
                () -> assertThat(s.solution(18)).isTrue(),
                () -> assertThat(s.solution(10)).isTrue(),
                () -> assertThat(s.solution(12)).isTrue(),
                () -> assertThat(s.solution(11)).isFalse(),
                () -> assertThat(s.solution(13)).isFalse(),
                () -> assertThat(s.solution(10000)).isTrue()
        );
    }


    @Test
    @DisplayName("숫자의 자릿수를 나오게 하는 테스트")
    void digitTest() {
        int inputNumber = 1234;
        assertAll(
                () -> assertThat(s.getOnlyOneNumber(inputNumber, 1)).isEqualTo(4),
                () -> assertThat(s.getOnlyOneNumber(inputNumber, 10)).isEqualTo(3),
                () -> assertThat(s.getOnlyOneNumber(inputNumber, 100)).isEqualTo(2),
                () -> assertThat(s.getOnlyOneNumber(inputNumber, 1000)).isEqualTo(1)
        );
    }



}

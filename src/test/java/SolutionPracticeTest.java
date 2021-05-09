import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class SolutionPracticeTest {

    @Test
    @DisplayName("하샤드 수인지 판별하는 TEST")
    void numberTest() {
        SolutionPractice s = new SolutionPractice();

        assertAll(
                () -> assertThat(s.solution(18)).isTrue(),
                () -> assertThat(s.solution(10)).isTrue(),
                () -> assertThat(s.solution(12)).isTrue(),
                () -> assertThat(s.solution(11)).isFalse(),
                () -> assertThat(s.solution(13)).isFalse(),
                () -> assertThat(s.solution(10000)).isTrue()
        );
    }

}

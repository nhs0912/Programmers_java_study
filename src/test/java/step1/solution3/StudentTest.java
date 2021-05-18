package step1.solution3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StudentTest {

    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    void setUp() {
        student1 = new Student(firstHumanAnswer);
        student2 = new Student(secondHumanAnswer);
        student3 = new Student(thirdHumanAnswer);
    }

    @Test
    @DisplayName("학생이 정답을 얼만큼 맞추었는지 TEST")
    void compareAnswerCountTest() {
        int[] answers = new int[]{1, 2, 3, 4, 5};

        assertAll(
                () -> assertThat(student1.comparedAnswerCount(answers)).isEqualTo(5),
                () -> assertThat(student2.comparedAnswerCount(answers)).isEqualTo(0),
                () -> assertThat(student3.comparedAnswerCount(answers)).isEqualTo(0)
        );
    }

}

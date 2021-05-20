package step1.solution3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TeacherTest {
    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private Student student1;
    private Student student2;
    private Student student3;
    private Teacher teacher;
    int[] answers = new int[]{1, 2, 3, 4, 5};

    @BeforeEach
    void setUp() {

        student1 = new Student(firstHumanAnswer, 1);
        student2 = new Student(secondHumanAnswer, 2);
        student3 = new Student(thirdHumanAnswer, 3);

        student1.comparedAnswerCount(answers);
        student2.comparedAnswerCount(answers);
        student3.comparedAnswerCount(answers);

        List<Student> students = Arrays.asList(student1, student2, student3);
        teacher = new Teacher(students);
    }

    @Test
    @DisplayName("1등을 나타내는 TEST")
    void winnerTest() {
        int[] ranks = teacher.firstRanks();
        assertThat(ranks).containsExactly(1);
    }
}

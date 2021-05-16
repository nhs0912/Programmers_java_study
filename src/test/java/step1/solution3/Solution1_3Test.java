package step1.solution3;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1_3Test {
    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    @Test
    @DisplayName("숫자만큼 정답을 loop도는지 확인")
    void loopTest() {
        Solution1_3 s = new Solution1_3();
        assertAll(
                () -> assertThat(s.loopAnswer(3, firstHumanAnswer)).containsExactly(1, 2, 3),
                () -> assertThat(s.loopAnswer(3, secondHumanAnswer)).containsExactly(2, 1, 2),
                () -> assertThat(s.loopAnswer(3, thirdHumanAnswer)).containsExactly(3, 3, 1)
        );


    }

}

package step1.solution3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution1_3Test {

    private Solution1_3 s = new Solution1_3();

    @Test
    @DisplayName("mainTest")
    void mainTest(){
        int[] answers = new int[]{1, 2, 3, 4, 5};
        assertThat(s.solution(answers)).containsExactly(1);

        int[] answers2 = new int[]{1, 3, 2, 4, 2};
        assertThat(s.solution(answers2)).containsExactly(1,2,3);
    }

}

package step1.NextBigNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SolutionTest {



    @Test
    @DisplayName("1bit count")
    void oneCountTest() {
        int inputNumber = 10;
        String binaryString = Integer.toBinaryString(inputNumber);
        int oneCount = Integer.bitCount(inputNumber);
        System.out.println(binaryString);
        System.out.println(oneCount);
    }


    @Test
    @DisplayName("다음 숫자 테스트")
    void nextNumberTest() {
        Solution solution = new Solution();

        assertAll(
                ()->assertThat(solution.solution(10)).isEqualTo(12),
                ()->assertThat(solution.solution(78)).isEqualTo(83),
                ()->assertThat(solution.solution(15)).isEqualTo(23)
        );

    }


}

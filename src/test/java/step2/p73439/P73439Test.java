package step2.p73439;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class P73439Test {
    private String[] participant;
    private String[] completion;

    @BeforeEach
    void setUp() {
        participant = new String[]{"leo", "kiki", "eden","kiki"};
        completion = new String[]{"kiki", "eden"};
    }

    @Test
    @DisplayName("미완주자 체크 테스트")
    void completionTest() {
        String answer = new Solution().solution(participant,completion);
        assertThat(answer).contains("leo");
    }

}

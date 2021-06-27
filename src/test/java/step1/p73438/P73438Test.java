package step1.p73438;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.LimitExceededException;

import static org.assertj.core.api.Assertions.assertThat;

public class P73438Test {


    private String s;

    @BeforeEach
    void setUp() {
        s = "(())";
    }


    @Test
    @DisplayName("올바른 괄호인지 확인")
    void rightParenthesisTest() throws LimitExceededException {
        s = "(())";
        ParenthesisTool parenthesisTool = new ParenthesisTool();
        boolean result = parenthesisTool.checkPairParenthesis(s);
        assertThat(result)
                .isTrue();
    }

    @Test
    @DisplayName("올바른지 않는 괄호인지 확인")
    void wrongParenthesisTest() throws LimitExceededException {
        s = ")()";
        ParenthesisTool parenthesisTool = new ParenthesisTool();
        boolean result = parenthesisTool.checkPairParenthesis(s);
        assertThat(result)
                .isFalse();
    }


}

package step1.makeprimenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

//import static org.assertj.core.api.Assertions.assertThat;
class PrimeNumberTest {

    @Test
    @DisplayName("입력된 숫자가 소수인지 판별하는 TEST")
    void isPrimeNumberTest() {
        PrimeNumber primeNumber = new PrimeNumber();
        assertAll(
                () -> assertThat(primeNumber.isPrimeNumber(10)).isFalse(),
                () -> assertThat(primeNumber.isPrimeNumber(150)).isFalse(),
                () -> assertThat(primeNumber.isPrimeNumber(3)).isTrue(),
                () -> assertThat(primeNumber.isPrimeNumber(11)).isTrue(),
                () -> assertThat(primeNumber.isPrimeNumber(37)).isTrue(),
                () -> assertThat(primeNumber.isPrimeNumber(101)).isTrue()
        );
    }
}

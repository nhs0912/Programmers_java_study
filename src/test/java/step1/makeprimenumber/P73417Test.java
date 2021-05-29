package step1.makeprimenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class P73417Test {

    @Test
    @DisplayName("조합 결과 나오는지 확인")
    void combinationTest() {

        int[] arr = new int[]{1, 2, 7, 6, 4};
        int start = 0;
        int r = 3;
        Combination combination = new Combination(arr);

        combination.execute(start, r);

        List<ThreeNumbers> threeNumbersList = combination.threeNumbersList();

        int primeNumberCount = 0;
        PrimeNumber primeNumber = new PrimeNumber();
        for (int i = 0; i < threeNumbersList.size(); i++) {
            int sum = threeNumbersList.get(i).sum();
            if (primeNumber.isPrimeNumber(sum)) {
                primeNumberCount++;
            }
        }
        assertThat(primeNumberCount).isEqualTo(4);
    }


}

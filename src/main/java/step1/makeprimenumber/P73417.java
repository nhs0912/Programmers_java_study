package step1.makeprimenumber;

class PrimeNumber {
    private static final int MAX_DATA_RANGE = 2998;
    private static final boolean[] primeNumberList = new boolean[MAX_DATA_RANGE];

    public PrimeNumber() {
        checkNotPrimeNumber();
    }

    public boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        if (number < MAX_DATA_RANGE) {
            return !primeNumberList[number];
        }
        throw new IllegalArgumentException("숫자 범위를 넘었습니다.");
    }

    private void checkNotPrimeNumber() {
        for (int i = 2; i * i < MAX_DATA_RANGE; i++) {

            if (primeNumberList[i]) {
                continue;
            }

            for (int j = i; i * j < MAX_DATA_RANGE; j++) {
                primeNumberList[i * j] = true;
            }
        }
    }
}


public class P73417 {

    public int solution(int[] nums) {
        int answer = -1;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

}

package step1.makeprimenumber;

import java.util.ArrayList;
import java.util.List;

class PrimeNumber {
    private static final int MAX_DATA_RANGE = 2998;
    private static boolean[] primeNumberList;

    public PrimeNumber() {
        if (primeNumberList == null) {
            primeNumberList = new boolean[MAX_DATA_RANGE];
            checkNotPrimeNumber();
        }
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

class Combination {

    private List<ThreeNumbers> threeNumbersList;
    private boolean[] visited;
    private int[] numbersArr;

    public Combination(int[] numbersArr) {
        this.threeNumbersList = new ArrayList<>();
        this.numbersArr = numbersArr;
        visited = new boolean[numbersArr.length];
    }

    public void execute(int start, int r) {

        if (r == 0) {
            threeNumbersList.add(getNumber());
            return;
        } else {
            for (int i = start; i < numbersArr.length; i++) {
                visited[i] = true;
                execute(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public int numberOfCases(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return numberOfCases(n - 1, r - 1) + numberOfCases(n - 1, r);
        }
    }


    public ThreeNumbers getNumber() {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersArr.length; i++) {
            if (visited[i] == true) {
                numbers.add(numbersArr[i]);
            }
        }
        return new ThreeNumbers(numbers);
    }

    public List<ThreeNumbers> threeNumbersList() {
        return this.threeNumbersList;
    }
}

class ThreeNumbers {
    int number1;
    int number2;
    int number3;

    public ThreeNumbers(List<Integer> numbers) {
        this(numbers.get(0), numbers.get(1), numbers.get(2));
    }

    public ThreeNumbers(int number1, int number2, int number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public int sum() {
        return this.number1 + this.number2 + this.number3;
    }
}

public class P73417 {

    public int solution(int[] nums) {
        int primeNumberCount = 0;

        int start = 0;
        int r = 3;
        Combination combination = new Combination(nums);

        combination.execute(start, r);

        List<ThreeNumbers> threeNumbersList = combination.threeNumbersList();
        PrimeNumber primeNumber = new PrimeNumber();

        for (int i = 0; i < threeNumbersList.size(); i++) {

            int sum = threeNumbersList.get(i).sum();

            if (primeNumber.isPrimeNumber(sum)) {
                primeNumberCount++;
            }
        }


        return primeNumberCount;
    }

}

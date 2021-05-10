package step1.HasadNumber;

import java.util.ArrayList;
import java.util.List;

public class SolutionPractice {

    public boolean solution(int x) {
        List<Integer> digits = getDigits(x);
        int sumNumber = sumDigits(digits);
        return isHarsaNumber(x, sumNumber);
    }

    public boolean isHarsaNumber(int inputNumber, int sumNumber) {
        return inputNumber % sumNumber == 0;
    }


    private int sumDigits(List<Integer> digits) {
        int sum = 0;
        for (Integer number : digits) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> getDigits(int inputNumber) {
        List<Integer> digitList = new ArrayList<>();
        int lengthNumber = (int) Math.floor(Math.log10(inputNumber)) + 1;
        int tenDigit = 1;
        for (int i = 1; i <= lengthNumber; i++) {
            digitList.add(getOnlyOneNumber(inputNumber, tenDigit));
            tenDigit *= 10;
        }
        return digitList;
    }

    public int getOnlyOneNumber(int inputNumber, int digit) {
        return (inputNumber / digit) % 10;
    }


}

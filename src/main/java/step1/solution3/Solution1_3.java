package step1.solution3;

import java.util.ArrayList;
import java.util.List;

public class Solution1_3 {

    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer = {};


        return answer;
    }

    public List<Integer> loopAnswer(int problemCount, int[] answers) {
        int index = 0;
        List<Integer> answerList = new ArrayList<>();
        while (problemCount-- > 0) {
            answerList.add(answers[index]);
            if (++index / answers.length == 1) {
                index = 0;
            }
        }
        return answerList;
    }

}

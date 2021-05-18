package step1.solution3;

import java.util.ArrayList;
import java.util.List;

class Student {
    private int[] myAnswers;

    public Student(int[] myAnswers) {
        this.myAnswers = myAnswers;
    }

    public int comparedAnswerCount(int[] correctedAnswer) {
        int answerCount = 0;
        int correctedAnswerSize = correctedAnswer.length;

        for (int i = 0; i < correctedAnswerSize; i++) {
            int myAnswerIndex = i % correctedAnswerSize;
            answerCount = oneAddedCount(myAnswers[myAnswerIndex], correctedAnswer[i], answerCount);
        }

        return answerCount;
    }

    private int oneAddedCount(int myAnswer, int answer, int answerCount) {
        return myAnswer == answer ? answerCount + 1 : answerCount;
    }

}


public class Solution1_3 {

    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    private static final int[] memberAnswerCountArray = new int[3];

    public int[] solution(int[] answers) {
        saveCorrectAnswerCount(answers);
        return highestScoreMember().stream().mapToInt(Integer::intValue).toArray();
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

    private void saveCorrectAnswerCount(int[] answers) {
        int answersSize = answers.length;

        List<Integer> firstHumanAnswerList = loopAnswer(answersSize, firstHumanAnswer);
        List<Integer> secondHumanAnswerList = loopAnswer(answersSize, secondHumanAnswer);
        List<Integer> thirdHumanAnswerList = loopAnswer(answersSize, thirdHumanAnswer);

        memberAnswerCountArray[0] = correctedAnswerCount(answers, firstHumanAnswerList);
        memberAnswerCountArray[1] = correctedAnswerCount(answers, secondHumanAnswerList);
        memberAnswerCountArray[2] = correctedAnswerCount(answers, thirdHumanAnswerList);
    }

    private List<Integer> highestScoreMember() {
        int bigNumber = bigCount();
        List<Integer> highestMemberList = new ArrayList<>();
        for (int i = 0; i < memberAnswerCountArray.length; i++) {
            int correctedAnswerCount = memberAnswerCountArray[i];
            if (correctedAnswerCount == bigNumber) {
                highestMemberList.add(i + 1);
            }
        }
        return highestMemberList;
    }


    private int bigCount() {
        int bigNumber = -1;
        for (int i = 0; i < memberAnswerCountArray.length; i++) {
            if (bigNumber < memberAnswerCountArray[i]) {
                bigNumber = memberAnswerCountArray[i];
            }
        }
        return bigNumber;
    }


    public int correctedAnswerCount(int[] answers, List<Integer> humanAnswers) {
        int answerCount = 0;
        for (int i = 0; i < answers.length; i++) {
            answerCount = oneAddedCount(humanAnswers.get(i), answers[i], answerCount);
        }
        return answerCount;
    }

    private int oneAddedCount(int humanAnswer, int answer, int answerCount) {
        return humanAnswer == answer ? answerCount + 1 : answerCount;
    }

}

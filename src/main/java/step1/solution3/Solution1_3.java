package step1.solution3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private int[] myAnswers;
    private int studentNumber;
    private int correctedAnswerCount;

    public Student(int[] myAnswers, int studentNumber) {
        this.myAnswers = myAnswers;
        this.studentNumber = studentNumber;
    }

    public int comparedAnswerCount(int[] correctedAnswer) {
        correctedAnswerCount = 0;
        int correctedAnswerSize = correctedAnswer.length;

        for (int i = 0; i < correctedAnswerSize; i++) {
            int myAnswerIndex = i % correctedAnswerSize;
            correctedAnswerCount = oneAddedCount(myAnswers[myAnswerIndex], correctedAnswer[i], correctedAnswerCount);
        }

        return correctedAnswerCount;
    }

    public int studentNumber() {
        return this.studentNumber;
    }

    public int correctedAnswerCount() {
        return this.correctedAnswerCount;
    }

    private int oneAddedCount(int myAnswer, int answer, int answerCount) {
        return myAnswer == answer ? answerCount + 1 : answerCount;
    }


    @Override
    public int compareTo(Student o) {
        return correctedAnswerCount - o.correctedAnswerCount;
    }
}

class Teacher {
    private List<Student> students;
    private int[] correctedAnswer;
    private int bigCorrectedAnswerCount = 0;

    public Teacher(List<Student> students, int[] correctedAnswer) {
        this.students = students;
        this.correctedAnswer = correctedAnswer;
    }

    public void gradeExam() {
        for (Student student : students) {
            student.comparedAnswerCount(correctedAnswer);
        }
    }

    public int[] firstRanks() {
        List<Student> highestMemberList = highestScoreMember();
        int[] resultStudentNumber = new int[highestMemberList.size()];
        Collections.sort(highestMemberList);

        for (int i = 0; i < highestMemberList.size(); i++) {
            resultStudentNumber[i] = highestMemberList.get(i).studentNumber();
        }
        return resultStudentNumber;
    }


    private List<Student> highestScoreMember() {
        bigCorrectedAnswerCount = bigCount();
        List<Student> highestMemberList = new ArrayList<>();
        for (Student student : students) {
            if (student.correctedAnswerCount() == bigCorrectedAnswerCount) {
                highestMemberList.add(student);
            }
        }
        return highestMemberList;
    }


    private int bigCount() {
        for (Student student : students) {
            if (bigCorrectedAnswerCount < student.correctedAnswerCount()) {
                bigCorrectedAnswerCount = student.correctedAnswerCount();
            }
        }
        return bigCorrectedAnswerCount;
    }
}


public class Solution1_3 {

    private static final int[] firstHumanAnswer = new int[]{1, 2, 3, 4, 5};
    private static final int[] secondHumanAnswer = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] thirdHumanAnswer = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        Student student1 = new Student(firstHumanAnswer, 1);
        Student student2 = new Student(secondHumanAnswer, 2);
        Student student3 = new Student(thirdHumanAnswer, 3);

        List<Student> students = Arrays.asList(student1, student2, student3);

        Teacher teacher = new Teacher(students, answers);
        teacher.gradeExam();

        return teacher.firstRanks();
    }
}

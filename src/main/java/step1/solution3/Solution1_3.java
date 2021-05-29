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

    public void comparedAnswerCount(int[] correctedAnswers) {
        correctedAnswerCount = 0;
        int myAnswersSize = myAnswers.length;

        for (int i = 0; i < correctedAnswers.length; i++) {
            int myAnswerIndex = i % myAnswersSize;
            matchAddOneCount(myAnswers[myAnswerIndex], correctedAnswers[i]);
        }
    }

    public int studentNumber() {
        return this.studentNumber;
    }

    public int correctedAnswerCount() {
        return this.correctedAnswerCount;
    }

    private void matchAddOneCount(int myAnswerNumber, int correctedAnswerNumber) {
        if (myAnswerNumber == correctedAnswerNumber) {
            this.correctedAnswerCount++;
        }
    }

    @Override
    public int compareTo(Student o) {
        return correctedAnswerCount - o.correctedAnswerCount;
    }
}

class Teacher {
    private List<Student> students;

    public Teacher(List<Student> students) {
        this.students = students;
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
        int bigCorrectedAnswerCount = bigCount();
        List<Student> highestMemberList = new ArrayList<>();
        for (Student student : students) {
            if (student.correctedAnswerCount() == bigCorrectedAnswerCount) {
                highestMemberList.add(student);
            }
        }
        return highestMemberList;
    }


    private int bigCount() {
        int bigCorrectedAnswerCount = 0;
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
    private Student student1 = new Student(firstHumanAnswer, 1);
    private Student student2 = new Student(secondHumanAnswer, 2);
    private Student student3 = new Student(thirdHumanAnswer, 3);

    public int[] solution(int[] answers) {
        student1.comparedAnswerCount(answers);
        student2.comparedAnswerCount(answers);
        student3.comparedAnswerCount(answers);

        List<Student> students = Arrays.asList(student1, student2, student3);

        Teacher teacher = new Teacher(students);


        return teacher.firstRanks();
    }
}

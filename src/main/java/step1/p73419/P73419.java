package step1.p73419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Word implements Comparable<Word> {
    private char criteria;
    private String word;

    public Word(String word, int index) {
        this.word = word;
        this.criteria = word.charAt(index);
    }

    public char criteria() {
        return this.criteria;
    }

    @Override
    public int compareTo(Word o) {
        return this.criteria > o.criteria ? 1 : 0;
    }
}

class Words {
    private List<Word> words;

    public Words(List<Word> words) {
        this.words = words;
    }

    public void sort() {
        Collections.sort(words);
    }

    public void print() {
        words.stream().forEach((str) -> System.out.print(str + " "));
    }
}

class Solution {
    public String[] solution(String[] inputWords, int n) {
        String[] answer = {};
        List<Word> wordList = new ArrayList<>();
        Arrays.stream(inputWords)
                .forEach(str -> wordList.add(new Word(str, n)));

        Words words = new Words(wordList);
        words.print();
        words.sort();
        words.print();

        return answer;
    }
}

public class P73419 {

    public static void main(String[] args) {
        String[] inputWords = new String[]{"sun", "bed", "car"};
        int n = 1;
        Solution solution = new Solution();
        solution.solution(inputWords, n);
    }

}

package step1.p73419;

import java.util.*;

class Word implements Comparable<Word> {
    private char criteria;
    private String word;

    public Word(String word, int index) {
        this.word = word;
        this.criteria = word.charAt(index);
    }

    public String word() {
        return this.word;
    }

    public char criteria() {
        return this.criteria;
    }

    @Override
    public int compareTo(Word o) {
        if(calculator(o) == 0){
            for(int i=0; i<o.word().length();i++){
                if(this.word.charAt(i) < o.word().charAt(i)){
                    return -1;
                }

                if(this.word.charAt(i) > o.word().charAt(i)){
                    return 1;
                }
            }
        }
        return calculator(o);
    }

    private int calculator(Word o){
        return this.criteria - o.criteria;
    }
}



class Words implements Iterable<Word> {
    private List<Word> words;

    public Words(List<Word> words) {
        this.words = words;
    }

    public void sort() {
        Collections.sort(words);
    }

    public String[] convertToStringArr() {
        String[] resultArray = new String[words.size()];
        int index = 0;
        for (Word word : this) {
            resultArray[index++] = word.word();
        }
        return resultArray;
    }

    public void print() {
        words.stream().forEach((str) -> System.out.print(str.word() + " " + str.criteria() + " "));
        System.out.println();
    }

    @Override
    public Iterator<Word> iterator() {
        return words.iterator();
    }
}

class Solution {
    public String[] solution(String[] inputWords, int n) {

        List<Word> wordList = new ArrayList<>();
        Arrays.stream(inputWords)
                .forEach(str -> wordList.add(new Word(str, n)));

        Words words = new Words(wordList);
        words.sort();
        return words.convertToStringArr();

    }
}

public class P73419 {

    public static void main(String[] args) {
        String[] inputWords = new String[]{"bed", "sun", "car"};
        int n = 1;
        Solution solution = new Solution();
        solution.solution(inputWords, n);
    }

}

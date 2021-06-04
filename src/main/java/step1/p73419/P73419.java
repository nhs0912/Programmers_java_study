package step1.p73419;

import java.util.Comparator;
import java.util.List;

class Word implements Comparator<Word>{
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
    public int compare(Word o1, Word o2) {
        if(o1.criteria > o2.criteria){

        }
        return 0;

    }
}

class Words{
    private List<Word> words;

    public Words(List<Word> words){
        this.words = words;
    }

    public void sort(){

    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
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

public class SolutionPractice {

    public boolean solution(int x) {
        boolean answer = true;
        int sum = (x / 10) + (x % 10);
        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }

}

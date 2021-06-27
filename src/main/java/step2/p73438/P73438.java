package step2.p73438;


import javax.naming.LimitExceededException;
import javax.naming.SizeLimitExceededException;

class MyStack {

    private char[] dataArray;
    private int top;

    public MyStack(int size) {
        dataArray = new char[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top >= dataArray.length;
    }

    public void push(char data) throws LimitExceededException {
        if (isFull()) {
            throw new LimitExceededException("Stack이 가득찼습니다.");
        }

        dataArray[++top] = data;
    }

    public char pop() throws SizeLimitExceededException {
        if (isEmpty()) {
            throw new SizeLimitExceededException("Stack이 모두 비어있습니다.");
        }

        return dataArray[top--];
    }
}


class ParenthesisTool {

    private MyStack myStack;
    private static final char RIGHT_PARENTHESIS = ')';
    private static final char LEFT_PARENTHESIS = '(';


    public boolean checkPairParenthesis(String inputParenthesisText) throws LimitExceededException {
        myStack = new MyStack(inputParenthesisText.length());
        for (int i = 0; i < inputParenthesisText.length(); i++) {
            char parenthesis = inputParenthesisText.charAt(i);
            if (parenthesis == LEFT_PARENTHESIS) {
                myStack.push(parenthesis);
            }

            if (parenthesis == RIGHT_PARENTHESIS) {
                if (myStack.isEmpty()) {
                    return false;
                }

                char popParenthesis = myStack.pop();

                if (popParenthesis == RIGHT_PARENTHESIS) {
                    return false;
                }
            }
        }

        if (!myStack.isEmpty()) {
            return false;
        }

        return true;

    }



}


class Solution {
    boolean solution(String inputParenthesisText) throws LimitExceededException {
        ParenthesisTool parenthesisTool = new ParenthesisTool();
        return parenthesisTool.checkPairParenthesis(inputParenthesisText);
    }
}


public class P73438 {

    public static void main(String[] args) throws LimitExceededException {
        String inputParenthesisText = "(())";
        new Solution().solution(inputParenthesisText);
    }

}

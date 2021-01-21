package stack;

import java.util.Stack;
public class infixToPrefix {
    static int Prec(char c1){
        switch (c1)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
    public static void main(String[] arg){
        String s = "(A-B/C)*(A/K-L)";
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i >-1 ; i--) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            else if(c=='(')
                stack.push(c);
            else if(c==')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                try {
                    if (!stack.isEmpty() && stack.peek() != '(')
                        System.out.println("Invalid Expression"); // invalid expression
                } catch (Exception e) {
                    stack.pop();
                }
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '(')
                        System.out.println( "Invalid Expression");
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                System.out.println( "Invalid Expression");
            result.append(stack.pop());
        }
        System.out.println(result.reverse());
    }
}
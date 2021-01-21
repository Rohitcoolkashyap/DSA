package stack;

import java.util.Stack;
public class infixToPostfix{
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
        StringBuilder result= new StringBuilder();
        String s = "a+b*(c^d-e)^(f+g*h)-i";//abc*+
        Stack<Character> stack = new Stack<>();

        for (char c:s.toCharArray()
        ) {
            if(Character.isLetterOrDigit(c))
            {
                result.append(c);
            }
            else if(c=='(')
                stack.push(c);
            else if(c==')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    System.out.println("Invalid Expression"); // invalid expression
                else
                    stack.pop();
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
        System.out.println(result);
    }
}

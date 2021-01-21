package stack;

import java.util.Stack;
public class PrefixToInfix {
    public static void main(String[] arg){
        String s="*+AB-CD";
        Stack<String> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                stack.push(String.valueOf(c));
            }
            else{
                String s1 = stack.pop();
                String s2 = stack.pop();

                String temp = "(" + s1 + c + s2 + ")";
                stack.push(temp);
            }
        }
        System.out.println(stack);
    }
    }

